package arch.module.moxymvp.ui

import arch.module.corenavigation.NestedNavigation
import moxy.MvpPresenter
import moxy.MvpView


abstract class BasePresenter<V : MvpView> : MvpPresenter<V>(), NestedNavigation {

//    @Inject
//    lateinit var router: MvpRouter

    override fun onBackPressed(): Boolean {
//        router.exit()
        return true
    }

}