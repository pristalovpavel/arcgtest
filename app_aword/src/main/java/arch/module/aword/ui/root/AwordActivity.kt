package arch.module.aword.ui.root

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arch.module.aword.R
import arch.module.aword.di.AwordAppComponent.Companion.appComponent
import arch.module.aword.ui.AwordRoutingScreen
import arch.module.core.other.MvpRouter
import arch.module.core.other.NestedNavigation
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject


class AwordActivity : AppCompatActivity() {


    @Inject
    lateinit var router: MvpRouter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_single_container)

        if (savedInstanceState == null) {
            router.replaceScreen(AwordRoutingScreen.LOGIN_FLOW)
//            router.replaceScreen(SkyengRoutingScreen.SKYNEG_MAIN)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        router.replaceScreen(AwordRoutingScreen.HELLO)
    }

    private val navigator by lazy { AwordNavigator(this) }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.layout_child_fragment_container)

        val isHandleByFragment = fragment is NestedNavigation && fragment.onBackPressed()
        if (!isHandleByFragment) {
            super.onBackPressed()
        }
    }
}