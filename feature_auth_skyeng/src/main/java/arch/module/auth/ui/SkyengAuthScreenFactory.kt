package arch.module.auth.ui

import androidx.fragment.app.Fragment
import arch.module.auth.ui.login.AuthScreenFragment


interface SkyengAuthScreenFactory {
    fun createSkyengAuthScreen(): Fragment
}

internal class SkyengAuthScreenFactoryImpl: SkyengAuthScreenFactory {
    override fun createSkyengAuthScreen(): Fragment {
        return AuthScreenFragment()
    }
}