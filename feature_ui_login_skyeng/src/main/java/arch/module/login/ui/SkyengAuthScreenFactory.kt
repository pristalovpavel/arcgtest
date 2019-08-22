package arch.module.login.ui

import androidx.fragment.app.Fragment
import arch.module.login.ui.login.AuthScreenFragment


interface SkyengAuthScreenFactory {
    fun createSkyengAuthScreen(): Fragment
}

internal class SkyengAuthScreenFactoryImpl : SkyengAuthScreenFactory {
    override fun createSkyengAuthScreen(): Fragment {
        return AuthScreenFragment()
    }
}