package arch.module.skyeng.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arch.module.corenavigation.MvpRouter
import arch.module.corenavigation.NestedNavigation
import arch.module.skyeng.R
import arch.module.skyeng.di.AppInjector
import arch.module.skyeng.di.SkyengAppComponent.Companion.appComponent
import arch.module.skyeng.ui.SkyengRoutingScreen
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject


class SkyengActivity : AppCompatActivity() {


    @Inject
    lateinit var router: MvpRouter

    @Inject
    lateinit var appInjector: AppInjector

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_single_container)

        if (savedInstanceState == null) {
            router.replaceScreen(SkyengRoutingScreen.SKYNEG_AUTH)
        }
    }

    private val navigator by lazy { SkyengNavigator(this, appInjector) }
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