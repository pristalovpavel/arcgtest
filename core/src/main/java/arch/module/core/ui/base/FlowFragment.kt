package arch.module.core.ui.base

import arch.module.core.R


abstract class FlowFragment<P : BasePresenter<*>> : BaseFragment<P>() {

    override fun getLayoutId(): Int = R.layout.fragment_single_container

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.layout_child_fragment_container) as? BaseFragment<*>

    override fun onBackPressed(): Boolean {
        return currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

}