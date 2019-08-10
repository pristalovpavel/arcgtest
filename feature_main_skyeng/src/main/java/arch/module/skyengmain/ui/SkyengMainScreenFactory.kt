package arch.module.skyengmain.ui

import androidx.fragment.app.Fragment


interface SkyengMainScreenFactory {
    fun createSkyengMainScreen(): Fragment
}

internal class SkyengMainScreenFactoryImpl : SkyengMainScreenFactory {
    override fun createSkyengMainScreen(): Fragment {
        return SkyengMainScreenFragment()
    }
}