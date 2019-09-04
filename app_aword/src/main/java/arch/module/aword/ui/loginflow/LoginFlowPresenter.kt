package arch.module.aword.ui.loginflow

import arch.module.core.di.PerFlow
import arch.module.core.ui.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@PerFlow
@InjectViewState
class LoginFlowPresenter @Inject constructor(
) : BasePresenter<ILoginFlowView>()