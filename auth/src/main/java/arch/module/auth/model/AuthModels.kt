package arch.module.auth.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("_username") val login: String,
    @field:SerializedName("_password") val password: String
)

data class AuthResponse(
    val token: String,
    val userId: Int
)
