package arch.module.skyeng.ui.screenC;

import android.os.Bundle
import android.view.View
import arch.module.skyeng.R
import arch.module.skyeng.ui.base.BaseFragment
import arch.module.skyeng.utils.ext.provideOut
import kotlinx.android.synthetic.main.fragment_screenc_layout.*
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class ScreenCFragment : BaseFragment<IScreenCView, ScreenCPresenter>(), IScreenCView {

    companion object {
        fun newInstance() = ScreenCFragment()
    }

    @InjectPresenter
    lateinit var presenter: ScreenCPresenter

    @ProvidePresenter
    fun providePresenter(): ScreenCPresenter = ScreenCPresenter(
        context.provideOut()
    )

    override fun getLayoutId(): Int = R.layout.fragment_screenc_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        сontinue.setOnClickListener {
            presenter.onClickContinue()
        }
    }
}