package arch.module.skyeng.ui.main

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import arch.module.skyeng.R
import arch.module.skyeng.di.AppInjector
import arch.module.skyeng.ui.SkyengRoutingScreen
import ru.terrakok.cicerone.android.SupportAppNavigator


class SkyengNavigator(
    activity: FragmentActivity,
    private val appInjector: AppInjector
) : SupportAppNavigator(activity, R.id.layout_child_fragment_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        SkyengRoutingScreen.SKYNEG_AUTH -> appInjector.provideSkyengAuthScreenFactory().createSkyengAuthScreen()
        SkyengRoutingScreen.SKYNEG_MAIN -> appInjector.provideSkyengMainScreenFactory().createSkyengMainScreen()
        else -> null
    }
}