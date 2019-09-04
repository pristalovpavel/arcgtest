package arch.module.aword.ui.loginflow

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import arch.module.auth.ui.login.AwordAuthScreenFragment
import arch.module.aword.R
import arch.module.aword.ui.welcome.WelcomeFragment
import arch.module.core.other.MvpRouter
import ru.terrakok.cicerone.android.SupportFragmentNavigator


class LoginFlowNavigator(
    private val router: MvpRouter,
    fragmentManager: FragmentManager,
    private val view: ILoginFlowView // низятак =)
) : SupportFragmentNavigator(fragmentManager, R.id.container_inner) {

    override fun exit() {
        router.exit()
    }

    override fun showSystemMessage(message: String?) {
        router.showSystemMessage(message)
    }


    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        view.updateText("ЭТОТ ТЕКСТ ВО FLOW (${screenKey ?: ""})")

        return when (screenKey) {
            LoginFlowRoutingScreen.AUTH -> AwordAuthScreenFragment()
            LoginFlowRoutingScreen.WELCOME -> WelcomeFragment.newInstance()
            else -> null
        }
    }
}