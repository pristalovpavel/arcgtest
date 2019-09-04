package arch.module.core.ui.base

import arch.module.core.other.MvpRouter
import arch.module.core.other.NestedNavigation
import moxy.MvpPresenter
import moxy.MvpView
import javax.inject.Inject


abstract class BasePresenter<V : MvpView> : MvpPresenter<V>(),
    NestedNavigation {

    @Inject
    lateinit var router: MvpRouter

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}