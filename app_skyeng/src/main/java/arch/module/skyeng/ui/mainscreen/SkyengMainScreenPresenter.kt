package arch.module.skyeng.ui.mainscreen

import arch.module.core.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
internal class SkyengMainScreenPresenter @Inject constructor(
    private val coordinator: ISkyengMainScreenCoordinator
) :
    BasePresenter<ISkyengMainScreenView>() {
    fun logout() {
        coordinator.exit()
    }
}