package arch.module.aword.ui.welcome;

import android.os.Bundle
import android.view.View
import arch.module.aword.R
import arch.module.aword.di.AwordAppComponent.Companion.appComponent
import arch.module.core.di.PerScreen
import arch.module.core.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_welcome_layout.*
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


@PerScreen
class WelcomeFragment : BaseFragment<WelcomePresenter>(), IWelcomeView {

    companion object {
        fun newInstance() = WelcomeFragment()
    }

    @InjectPresenter
    override lateinit var presenter: WelcomePresenter

    @ProvidePresenter
    override fun providePresenter(): WelcomePresenter = super.providePresenter()

    override fun getLayoutId(): Int = R.layout.fragment_welcome_layout

    override fun diInject() {
        appComponent.welcomeComponentBuilder()
            .build().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        go.setOnClickListener {
            presenter.showNextScreen()
        }
    }
}

interface IWelcomeView : MvpView