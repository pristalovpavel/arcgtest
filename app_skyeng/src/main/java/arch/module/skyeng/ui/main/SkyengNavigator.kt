package arch.module.skyeng.ui.main

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import arch.module.auth.ui.SkyengAuthScreenFactory
import arch.module.skyeng.R
import ru.terrakok.cicerone.android.SupportAppNavigator


class SkyengNavigator(
    activity: FragmentActivity,
    private val authScreenFactory: SkyengAuthScreenFactory
) : SupportAppNavigator(activity, R.id.layout_child_fragment_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        "auth_screen" -> authScreenFactory.createSkyengAuthScreen()
        else -> null
    }
}