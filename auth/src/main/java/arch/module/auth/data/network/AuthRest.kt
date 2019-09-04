package arch.module.auth.data.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthRest {

    @POST("auth/login")
    fun login(@Body params: LoginRequest): Single<AuthResponse>
}