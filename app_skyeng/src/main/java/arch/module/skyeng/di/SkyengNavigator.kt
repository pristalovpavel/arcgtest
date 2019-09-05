package arch.module.skyeng.di

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import arch.module.skyeng.R
import arch.module.skyeng.ui.NavigationConst
import arch.module.skyeng.ui.screenA.ScreenAFragment
import arch.module.skyeng.ui.screenA.ScreenBFragment
import ru.terrakok.cicerone.android.SupportAppNavigator


class SkyengNavigator(
    activity: FragmentActivity
) : SupportAppNavigator(activity, R.id.layout_child_fragment_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        NavigationConst.SCREEN_A -> ScreenAFragment.newInstance()
        NavigationConst.SCREEN_B -> ScreenBFragment.newInstance()
        else -> null
    }
}