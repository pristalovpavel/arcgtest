package arch.module.auth.usecase.data.network

import arch.module.auth.model.AuthResponse
import arch.module.auth.model.LoginRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthRest {

    @POST("auth/login")
    fun login(@Body params: LoginRequest): Single<AuthResponse>
}