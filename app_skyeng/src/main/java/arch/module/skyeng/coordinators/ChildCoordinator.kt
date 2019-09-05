package arch.module.skyeng.coordinators

import arch.module.skyeng.ui.NavigationConst
import arch.module.skyeng.ui.screenB.DonePressed
import arch.module.skyeng.ui.screenB.ScreenBOutCmd
import arch.module.skyeng.ui.screenC.ContinuePressed
import arch.module.skyeng.ui.screenC.ScreenCOutCmd
import ru.terrakok.cicerone.Router


class ChildCoordinator(
    private val router: ChildRouter
) {

    operator fun invoke(out: (ChildCoordinatorOutCmd) -> Unit) {
        router.openScreenC { outC: ScreenCOutCmd ->
            when (outC) {
                is ContinuePressed -> router.openScreenB { outB: ScreenBOutCmd ->
                    when (outB) {
                        is DonePressed -> out(ChildCoordinatorDone)
                    }
                }
            }
        }
    }
}

sealed class ChildCoordinatorOutCmd

object ChildCoordinatorDone : ChildCoordinatorOutCmd()


class ChildRouter(
    private val router: Router,
    private val callback: OutCallback
) {

    fun openScreenC(out: (ScreenCOutCmd) -> Unit) {
        callback(out)
        router.navigateTo(NavigationConst.SCREEN_C)
    }

    fun openScreenB(out: (ScreenBOutCmd) -> Unit) {
        callback(out)
        router.navigateTo(NavigationConst.SCREEN_B)
    }
}