package arch.module.skyeng.ui.screenA;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arch.module.skyeng.R
import moxy.InjectViewState
import moxy.MvpAppCompatFragment
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class ScreenAFragment :  MvpAppCompatFragment(), IScreenAView {

    companion object {
        fun newInstance() = ScreenAFragment()
    }

    @InjectPresenter
    lateinit var presenter: ScreenAPresenter

    @ProvidePresenter
    fun providePresenter(): ScreenAPresenter = ScreenAPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun getLayoutId(): Int = R.layout.fragment_screena_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}


@InjectViewState
class ScreenAPresenter @Inject constructor(
) :  MvpPresenter<IScreenAView>() {

}

interface IScreenAView : MvpView {

}