package arch.module.skyeng.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arch.module.skyeng.R
import arch.module.skyeng.coordinators.RootCoordinator
import arch.module.skyeng.di.Navigation
import arch.module.skyeng.di.SkyengNavigator


class SkyengActivity : AppCompatActivity() {

    val router = Navigation.instanse.router

    val navigatorHolder = Navigation.instanse.navigatorHolder

    private val rootCoordinator = RootCoordinator(router)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_skyeng)

        if (savedInstanceState == null) {
            rootCoordinator.showStartScreen()
        }
    }


    private val navigator by lazy { SkyengNavigator(this) }

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

//        val isHandleByFragment = fragment is NestedNavigation && fragment.onBackPressed()
//        if (!isHandleByFragment) {
        super.onBackPressed()
//        }
    }
}