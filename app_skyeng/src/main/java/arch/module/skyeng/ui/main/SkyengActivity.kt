package arch.module.skyeng.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import arch.module.skyeng.R
import arch.module.skyeng.coordinators.IGetOutProvider
import arch.module.skyeng.coordinators.Out
import arch.module.skyeng.coordinators.RootCoordinator
import arch.module.skyeng.di.Navigation
import arch.module.skyeng.di.SkyengNavigator


class SkyengActivity : AppCompatActivity(), IGetOutProvider {

    private val router = Navigation.instance.router
    private val navigatorHolder = Navigation.instance.navigatorHolder

    private var out: Any? = null
    private val rootCoordinator = RootCoordinator(router) { value ->
        out = value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_skyeng)

        if (savedInstanceState == null) {
            Toast.makeText(this, "cold start", Toast.LENGTH_SHORT).show()
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

    override fun provideOut(): Out = popOut()

    private fun popOut(): Out {
        val local: Any = out ?: throw IllegalAccessException("жёпка =(")
        out = null
        return local
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.layout_child_fragment_container)

//        val isHandleByFragment = fragment is NestedNavigation && fragment.onBackPressed()
//        if (!isHandleByFragment) {
        super.onBackPressed()
//        }
    }
}