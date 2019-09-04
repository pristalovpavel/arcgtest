package arch.module.auth.di

import arch.module.auth.di.module.AuthCoordinatorModule
import arch.module.auth.ui.login.AuthScreenFragment
import arch.module.core.di.NavigationDependencies
import arch.module.core.di.PerScreen
import arch.module.core.di.RestDependencies
import arch.module.core.di.UrlDependencies
import arch.module.userprofile.api.UserProfileDeps
import dagger.Component


@PerScreen
@Component(
    dependencies = [
        NavigationDependencies::class,
        RestDependencies::class,
        UrlDependencies::class,
        UserProfileDeps::class
    ],
    modules = [
        AuthModule::class,
        AuthCoordinatorModule::class
    ]

)
interface SkyengAuthComponent {
    fun inject(activity: AuthScreenFragment)

    companion object {
        fun init(
            navigation: NavigationDependencies,
            restDependencies: RestDependencies,
            urlDependencies: UrlDependencies,
            userProfileDeps: UserProfileDeps
        ): SkyengAuthComponent =
            DaggerSkyengAuthComponent.builder()
                .navigationDependencies(navigation)
                .restDependencies(restDependencies)
                .urlDependencies(urlDependencies)
                .userProfileDeps(userProfileDeps)
                .build()
    }
}
