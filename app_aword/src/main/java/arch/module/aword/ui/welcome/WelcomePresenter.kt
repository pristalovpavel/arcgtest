package arch.module.aword.ui.welcome

import arch.module.core.di.PerScreen
import arch.module.core.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@PerScreen
@InjectViewState
class WelcomePresenter @Inject constructor(
    private val coordinator: IWelcomeCoordinator
) : BasePresenter<IWelcomeView>() {
    fun showNextScreen() {
        viewState.showNotification()
//        coordinator.showNextScreen()
    }
}