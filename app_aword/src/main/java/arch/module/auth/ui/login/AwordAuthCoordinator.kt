package arch.module.auth.ui.login

import arch.module.aword.ui.loginflow.LoginFlowRoutingScreen
import arch.module.core.di.modules.FlowRouter
import javax.inject.Inject


class AwordAuthCoordinator @Inject constructor(
    private val router: FlowRouter
) : IAuthCoordinator {
    override fun openMainScreen() {
        router.replaceScreen(LoginFlowRoutingScreen.WELCOME)
    }
}