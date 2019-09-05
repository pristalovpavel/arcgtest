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
    private val router: Router
) {

    private lateinit var screenAIn: ScreenAIn

    fun showStartScreen() {
        val qwe: (ScreenAOutCmd) -> Unit = {
            when (it) {
                is GoPressed -> router.navigateTo(NavigationConst.SCREEN_B)
                is OnCreate -> screenAIn = it.input
            }
        }
        CoordinatorParamHolder.registerOut("key", qwe)

        val qwe2: (ScreenBOutCmd) -> Unit = {
            when (it) {
                is DonePressed -> {
                    screenAIn.done()
                    router.exit()
                }
            }
        }
        CoordinatorParamHolder.registerOut("key2", qwe2)
        router.navigateTo(NavigationConst.SCREEN_A)
    }
}