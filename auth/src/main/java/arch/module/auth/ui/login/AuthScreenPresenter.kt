package arch.module.auth.ui.login

import android.annotation.SuppressLint
import arch.module.auth.usecase.LoginUseCase
import arch.module.core.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class AuthScreenPresenter @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val coordinator: IAuthCoordinator
) : BasePresenter<AuthScreenView>() {

    @SuppressLint("CheckResult")
    fun doLogin(login: String, password: String) {
        // todo добавит лоадер
        // todo пример\сравнения с LoadUseCase
        loginUseCase(login, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    coordinator.openMainScreen()
                },
                {
                    viewState.showError(it)
                }
            )
    }
}