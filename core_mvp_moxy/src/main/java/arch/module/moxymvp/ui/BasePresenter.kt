package arch.module.moxymvp.ui

import arch.module.corenavigation.MvpRouter
import arch.module.corenavigation.NestedNavigation
import moxy.MvpPresenter
import moxy.MvpView
import javax.inject.Inject


abstract class BasePresenter<V : MvpView> : MvpPresenter<V>(), NestedNavigation {

    @Inject
    lateinit var router: MvpRouter

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}