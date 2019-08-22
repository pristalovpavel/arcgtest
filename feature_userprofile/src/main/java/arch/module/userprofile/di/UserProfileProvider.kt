package arch.module.userprofile.di

import arch.module.corenetwork.api.RestDependencies
import arch.module.corenetwork.api.UrlDependencies
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

