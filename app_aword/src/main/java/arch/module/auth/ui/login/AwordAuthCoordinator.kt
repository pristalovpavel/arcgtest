package arch.module.auth.ui.login

import arch.module.aword.ui.AwordRoutingScreen
import arch.module.core.other.MvpRouter
import javax.inject.Inject


class AwordAuthCoordinator @Inject constructor(
    private val router: MvpRouter
) : IAuthCoordinator {
    override fun openMainScreen() {
        router.replaceScreen(AwordRoutingScreen.WELCOME)
    }
}