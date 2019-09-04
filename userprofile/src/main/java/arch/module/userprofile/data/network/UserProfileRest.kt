package arch.module.userprofile.data.network

import io.reactivex.Single
import retrofit2.http.GET


interface UserProfileRest {

    @GET("/api/for-mobile/v1/profile.json")
    fun userInfoMobile(): Single<UserDataMobile>

    @GET("api/v1/userSchoolInfo.json")
    fun schoolInfo(): Single<SchoolInfo>
}