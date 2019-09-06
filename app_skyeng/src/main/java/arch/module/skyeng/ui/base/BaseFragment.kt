package arch.module.skyeng.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.MvpPresenter
import moxy.MvpView


abstract class BaseFragment<V : MvpView, P : BasePresenter<V>> : MvpAppCompatFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

}

abstract class BasePresenter<V : MvpView> : MvpPresenter<V>()