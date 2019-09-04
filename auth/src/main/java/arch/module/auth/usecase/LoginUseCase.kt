package arch.module.auth.usecase

import arch.module.auth.model.LoginRequest
import arch.module.core.usecase.data.other.TokenHolder
import arch.module.auth.usecase.data.network.AuthRest
import dagger.Reusable
import io.reactivex.Completable
import javax.inject.Inject


@Reusable
class LoginUseCase @Inject constructor(
    private val authRest: AuthRest,
    private var tokenHolder: TokenHolder
) {
    operator fun invoke(login: String, password: String): Completable {
        return authRest.login(LoginRequest(login, password))
            .doOnSuccess {
                tokenHolder.token = it.token
            }
            .ignoreElement()
    }
}