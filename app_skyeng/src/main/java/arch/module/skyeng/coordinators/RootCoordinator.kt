package arch.module.skyeng.coordinators

import arch.module.skyeng.ui.NavigationConst
import arch.module.skyeng.ui.screenA.ButtonPressed
import arch.module.skyeng.ui.screenA.ScreenAOutCmd
import ru.terrakok.cicerone.Router


class RootCoordinator(
    private val router: Router
) {

    fun showStartScreen() {
        val qwe: (ScreenAOutCmd) -> Unit = {
            when (it) {
                ButtonPressed -> router.navigateTo(NavigationConst.SCREEN_B)
            }
        }
        CoordinatorParamHolder.registerOut("key", qwe)
        router.navigateTo(NavigationConst.SCREEN_A)
    }
}