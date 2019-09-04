package arch.module.core.usecase.data.other

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TokenHolder @Inject constructor() {

    var token: String? = null

    fun getAuthorization(): String? {
       return "Bearer $token"
    }

}