package arch.module.userprofile.api

import android.content.Context
import arch.module.core.di.findComponentDependencies
import arch.module.userprofile.di.UserProfileProvider
import arch.module.userprofile.domain.GetUserInfoUseCase
import dagger.Component


//@PerFeature
@Component(
    dependencies = [
        UserProfileProvider::class]
)
interface UserProfileComponentProvider : UserProfileDeps {

    companion object {

        fun init(context: Context): UserProfileComponentProvider {
            return DaggerUserProfileComponentProvider.builder()
                .userProfileProvider(
                    UserProfileProvider.init(
                        context.findComponentDependencies(),
                        context.findComponentDependencies()
                    )
                )
                .build()
        }
    }

}

interface UserProfileDeps{
    fun provideGetUserInfoUseCase(): GetUserInfoUseCase

}