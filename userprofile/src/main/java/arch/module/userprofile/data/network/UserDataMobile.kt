package arch.module.userprofile.data.network

import com.google.gson.annotations.SerializedName

data class UserDataMobile(
    val userId: Int,
    val identity: String, // у студентов - это email
    val name: String,
    val surname: String,
    val isAwordUser: Boolean,
    val age: Int?,
    private val role: UserRole?
)

enum class UserRole {

    @SerializedName("teacher")
    TEACHER,

    @SerializedName("student")
    STUDENT,

    NOT_SET
}
