package arch.module.skyeng.coordinators

import arch.module.skyeng.ui.NavigationConst
import arch.module.skyeng.ui.screenA.GoPressed
import arch.module.skyeng.ui.screenA.OnCreate
import arch.module.skyeng.ui.screenA.ScreenAIn
import arch.module.skyeng.ui.screenA.ScreenAOutCmd
import arch.module.skyeng.ui.screenB.DonePressed
import arch.module.skyeng.ui.screenB.ScreenBOutCmd
import ru.terrakok.cicerone.Router


class RootCoordinator(
    private val router: RootRouter
) {

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
                is OnCreate -> screenAIn = outA.input
            }
        }
    }
}

class RootRouter(
    private val router: Router

) {
    fun openScreenA(out: (ScreenAOutCmd) -> Unit) {
        CoordinatorParamHolder.registerOut("key", out)
        router.navigateTo(NavigationConst.SCREEN_A)
    }

    fun openScreenB(out: (ScreenBOutCmd) -> Unit) {
        CoordinatorParamHolder.registerOut("key2", out)
        router.navigateTo(NavigationConst.SCREEN_B)
    }

    fun closeScreenB() {
        router.exit()
    }
}