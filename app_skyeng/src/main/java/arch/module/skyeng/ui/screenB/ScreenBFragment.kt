package arch.module.skyeng.ui.screenB;

import android.os.Bundle
import android.view.View
import arch.module.skyeng.R
import arch.module.skyeng.ui.base.BaseFragment
import arch.module.skyeng.utils.ext.provideOut
import kotlinx.android.synthetic.main.fragment_screenb_layout.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class ScreenBFragment : BaseFragment<IScreenBView, ScreenBPresenter>(), IScreenBView {

    companion object {
        fun newInstance() = ScreenBFragment()
    }

    @InjectPresenter
    lateinit var presenter: ScreenBPresenter

    @ProvidePresenter
    fun providePresenter(): ScreenBPresenter = ScreenBPresenter(
        context.provideOut()
    )

    override fun getLayoutId(): Int = R.layout.fragment_screenb_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button.setOnClickListener {
            presenter.onClickDone()
        }
    }
}