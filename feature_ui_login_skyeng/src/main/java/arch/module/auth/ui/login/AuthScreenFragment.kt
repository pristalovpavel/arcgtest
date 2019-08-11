package arch.module.auth.ui.login

import android.os.Bundle
import android.view.View
import arch.module.auth.R
import arch.module.auth.di.SkyengAuthComponent
import arch.module.coreutils.di.findComponentDependencies
import arch.module.moxymvp.ui.BaseFragment
import arch.module.moxymvp.utils.trimmedText
import kotlinx.android.synthetic.main.fragment_auth_screen.*
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


internal class AuthScreenFragment : BaseFragment<AuthScreenPresenter>(), AuthScreenView {

    @InjectPresenter
    override lateinit var presenter: AuthScreenPresenter

    @ProvidePresenter
    override fun providePresenter(): AuthScreenPresenter = super.providePresenter()

    override fun getLayoutId(): Int = R.layout.fragment_auth_screen

    override fun diInject() {
        SkyengAuthComponent.init(
            findComponentDependencies(),
            findComponentDependencies(),
            findComponentDependencies()
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        enter_login.setOnClickListener {
            presenter.doLogin(login.trimmedText, password.trimmedText)
        }
    }

    override fun showError(it: Throwable?) {
        it?.let { showToast(it.toString()) }
    }
}

internal interface AuthScreenView : MvpView {
    @StateStrategyType(value = SkipStrategy::class)
    fun showError(it: Throwable?)
}