package arch.module.skyeng.coordinators

import arch.module.skyeng.ui.NavigationConst
import arch.module.skyeng.ui.screenA.*
import arch.module.skyeng.ui.screenB.DonePressed
import arch.module.skyeng.ui.screenB.ScreenBOutCmd
import ru.terrakok.cicerone.Router


class RootCoordinator(
    private val cheRouter: Router,
    private val callback: OutCallback
) {
    private val router: RootRouter = RootRouter(cheRouter, callback)

    private var counter: Int = 0

    private lateinit var screenAIn: ScreenAIn

    fun showStartScreen() {
        router.openScreenA { outA: ScreenAOutCmd ->
            when (outA) {
                is GoPressed -> router.openScreenB { outB: ScreenBOutCmd ->
                    when (outB) {
                        is DonePressed -> {
                            router.closeScreenB()
                            screenAIn.done(++counter)
                        }
                    }
                }
                is ChildPressed -> ChildCoordinator(ChildRouter(cheRouter, callback))() {
                    when (it) {
                        is ChildCoordinatorDone -> {
                            screenAIn.coordinatorDone()
                            router.backToScreenA()
                        }
                    }
                }
                is OnCreate -> screenAIn = outA.input
            }
        }
    }
}

class RootRouter(
    router: Router,
    callback: OutCallback
) : BaseRouter(router, callback) {

    fun openScreenA(out: (ScreenAOutCmd) -> Unit) = navigateTo(out, NavigationConst.SCREEN_A)

    fun openScreenB(out: (ScreenBOutCmd) -> Unit) = navigateTo(out, NavigationConst.SCREEN_B)

    fun closeScreenB() = exit()

    fun backToScreenA() = backTo(NavigationConst.SCREEN_A)
}