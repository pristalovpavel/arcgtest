package arch.module.aword.ui.root

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import arch.module.auth.ui.login.AwordAuthScreenFragment
import arch.module.aword.R
import arch.module.aword.ui.AwordRoutingScreen.AUTH
import ru.terrakok.cicerone.android.SupportAppNavigator


class AwordNavigator(
    activity: FragmentActivity
) : SupportAppNavigator(activity, R.id.layout_child_fragment_container) {

    override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
        AUTH -> AwordAuthScreenFragment()
        else -> null
    }
}