package arch.module.auth.ui.login

import arch.module.core.other.MvpRouter
import arch.module.skyeng.ui.SkyengRoutingScreen
import javax.inject.Inject


class SkyengAuthCoordinator @Inject constructor(
    private val router: MvpRouter
) : IAuthCoordinator {
    override fun openMainScreen() {
        router.replaceScreen(SkyengRoutingScreen.SKYNEG_MAIN)
    }
}