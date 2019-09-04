package arch.module.core.ui.base

import arch.module.core.other.NestedNavigation
import moxy.MvpPresenter
import moxy.MvpView


abstract class BasePresenter<V : MvpView> : MvpPresenter<V>(),
    NestedNavigation {


    override fun onBackPressed(): Boolean {
        return false
    }

}