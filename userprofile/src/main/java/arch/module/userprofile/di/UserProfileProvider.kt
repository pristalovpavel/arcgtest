package arch.module.userprofile.di

import arch.module.core.di.RestDependencies
import arch.module.core.di.UrlDependencies
import arch.module.userprofile.api.UserProfileDeps
import dagger.Component


//@PerFeature
@Component(
    dependencies = [
        RestDependencies::class, UrlDependencies::class
    ],
    modules = [ProfileModule::class]
)
internal interface UserProfileProvider : UserProfileDeps {

    companion object {
        fun init(
            restDependencies: RestDependencies,
            urlDependencies: UrlDependencies
        ): UserProfileProvider {
            return DaggerUserProfileProvider.builder()
                .restDependencies(restDependencies)
                .urlDependencies(urlDependencies)
                .build()
        }
    }
}

