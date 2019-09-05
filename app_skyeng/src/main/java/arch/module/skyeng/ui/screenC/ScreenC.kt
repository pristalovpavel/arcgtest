package arch.module.skyeng.ui.screenC;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arch.module.skyeng.R
import arch.module.skyeng.ui.provideOut
import kotlinx.android.synthetic.main.fragment_screenc_layout.*
import moxy.InjectViewState
import moxy.MvpAppCompatFragment
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class ScreenCFragment : MvpAppCompatFragment(), IScreenCView {

    companion object {
        fun newInstance() = ScreenCFragment()
    }

    @InjectPresenter
    lateinit var presenter: ScreenCPresenter

    @ProvidePresenter
    fun providePresenter(): ScreenCPresenter = ScreenCPresenter(
        context.provideOut()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun getLayoutId(): Int = R.layout.fragment_screenc_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        сontinue.setOnClickListener {
            presenter.onClickContinue()
        }
    }
}

sealed class ScreenCOutCmd

object ContinuePressed : ScreenCOutCmd()


@InjectViewState
class ScreenCPresenter @Inject constructor(
    private val cmd: (ScreenCOutCmd) -> Unit
) : MvpPresenter<IScreenCView>() {
    fun onClickContinue() {
        cmd(ContinuePressed)
    }

}

interface IScreenCView : MvpView