package arch.module.userprofile.domain

import arch.module.userprofile.data.network.UserProfileRest
import dagger.Reusable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject


@Reusable
class GetUserInfoUseCase @Inject constructor(
    private val rest: UserProfileRest
) {

    operator fun invoke(): Single<UserInfo> {

        return Single.zip(
            rest.schoolInfo(),
            rest.userInfoMobile(),
            BiFunction { school, user ->
                return@BiFunction UserInfo(user.identity, school.paidLessonsNum)
            }
        )
    }
}


data class UserInfo(
    val identity: String,
    val lessonCount: Int
)