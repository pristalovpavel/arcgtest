package arch.module.auth.ui.login

import android.os.Bundle
import android.view.View
import arch.module.auth.R
import arch.module.auth.di.SkyengAuthComponent
import arch.module.moxymvp.ui.BaseFragment
import arch.module.moxymvp.ui.BasePresenter
import kotlinx.android.synthetic.main.fragment_auth_screen.*
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


internal class AuthScreenFragment : BaseFragment<AuthScreenPresenter>() {

    @InjectPresenter
    override lateinit var presenter: AuthScreenPresenter

    @ProvidePresenter
    override fun providePresenter(): AuthScreenPresenter = super.providePresenter()

    override fun getLayoutId(): Int = R.layout.fragment_auth_screen

    override fun diInject() {
        SkyengAuthComponent.init().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enter_login.setOnClickListener {
            showToast("Вхожу!")
        }
    }
}

internal class AuthScreenPresenter @Inject constructor() : BasePresenter<AuthScreenView>()

internal interface AuthScreenView : MvpView