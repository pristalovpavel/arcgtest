package arch.module.auth.domain

import arch.module.auth.data.network.AuthRest
import arch.module.auth.data.network.LoginRequest
import arch.module.corenetwork.data.TokenHolder
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