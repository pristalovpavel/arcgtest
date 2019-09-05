package arch.module.skyeng.ui.screenB;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arch.module.skyeng.R
import arch.module.skyeng.coordinators.CoordinatorParamHolder
import kotlinx.android.synthetic.main.fragment_screenb_layout.*
import moxy.InjectViewState
import moxy.MvpAppCompatFragment
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class ScreenBFragment : MvpAppCompatFragment(), IScreenBView {

    companion object {
        fun newInstance() = ScreenBFragment()
    }

    @InjectPresenter
    lateinit var presenter: ScreenBPresenter

    @ProvidePresenter
    fun providePresenter(): ScreenBPresenter = ScreenBPresenter(
        CoordinatorParamHolder.provideOut("key2")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun getLayoutId(): Int = R.layout.fragment_screenb_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button.setOnClickListener {
            presenter.onClickDone()
        }
    }
}

sealed class ScreenBOutCmd

object DonePressed : ScreenBOutCmd()


@InjectViewState
class ScreenBPresenter @Inject constructor(
    private val cmd: (ScreenBOutCmd) -> Unit
) : MvpPresenter<IScreenBView>() {
    fun onClickDone() {
        cmd(DonePressed)
    }

}

interface IScreenBView : MvpView {

}