package arch.module.aword.ui.welcome

import arch.module.aword.ui.AwordRoutingScreen
import arch.module.core.other.MvpRouter
import javax.inject.Inject

interface IWelcomeCoordinator {
    fun showNextScreen()
}


class WelcomeCoordinator @Inject constructor(
    private val router: MvpRouter
) : IWelcomeCoordinator {
    override fun showNextScreen() {
        router.replaceScreen(AwordRoutingScreen.MAIN)
    }
}