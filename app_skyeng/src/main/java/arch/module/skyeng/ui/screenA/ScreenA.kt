package arch.module.skyeng.ui.screenA;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arch.module.skyeng.R
import arch.module.skyeng.di.Navigation
import arch.module.skyeng.ui.NavigationConst
import kotlinx.android.synthetic.main.fragment_screena_layout.*
import moxy.InjectViewState
import moxy.MvpAppCompatFragment
import moxy.MvpPresenter
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.Router


class ScreenAFragment : MvpAppCompatFragment(), IScreenAView {

    companion object {
        fun newInstance() = ScreenAFragment()
    }

    @InjectPresenter
    lateinit var presenter: ScreenAPresenter

    @ProvidePresenter
    fun providePresenter(): ScreenAPresenter = ScreenAPresenter(
        Navigation.instanse.router
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun getLayoutId(): Int = R.layout.fragment_screena_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button.setOnClickListener {
            presenter.openNextScreen()
        }
    }
}

@InjectViewState
class ScreenAPresenter constructor(
    private val router: Router
) : MvpPresenter<IScreenAView>() {

    fun openNextScreen() {
        router.navigateTo(NavigationConst.SCREEN_B)
    }

}

interface IScreenAView : MvpView {

}