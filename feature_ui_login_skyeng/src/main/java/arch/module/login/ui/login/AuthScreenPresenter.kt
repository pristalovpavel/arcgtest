package arch.module.login.ui.login

import android.annotation.SuppressLint
import arch.module.auth.domain.LoginUseCase
import arch.module.core.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
internal class AuthScreenPresenter @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BasePresenter<AuthScreenView>() {
    @SuppressLint("CheckResult")
    fun doLogin(login: String, password: String) {
        loginUseCase(login, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {
                router.replaceScreen("SKYNEG_MAIN") // todo заменить на другое
            },
            {
                viewState.showError(it)
            }
        )
    }
}