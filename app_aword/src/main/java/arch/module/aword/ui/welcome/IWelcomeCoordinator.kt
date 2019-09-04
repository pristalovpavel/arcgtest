package arch.module.aword.ui.welcome

import javax.inject.Inject

interface IWelcomeCoordinator {
    fun showNextScreen()
}


class WelcomeCoordinator @Inject constructor() : IWelcomeCoordinator {
    override fun showNextScreen() {
    }
}