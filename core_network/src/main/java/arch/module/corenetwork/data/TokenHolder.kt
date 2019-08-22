package arch.module.corenetwork.data

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TokenHolder @Inject constructor() {

    var token: String? = null

    fun getAuthorization(): String? {
       return "Bearer $token"
    }

}