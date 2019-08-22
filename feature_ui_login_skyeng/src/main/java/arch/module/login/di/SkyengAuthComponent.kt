package arch.module.login.di

import arch.module.auth.di.AuthComponentProvider
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenetwork.api.RestDependencies
import arch.module.corenetwork.api.UrlDependencies
import arch.module.coreutils.di.PerScreen
import arch.module.login.ui.login.AuthScreenFragment
import dagger.Component


@PerScreen
@Component(
    dependencies = [
        NavigationDependencies::class,
        AuthComponentProvider::class
    ]
)
internal interface SkyengAuthComponent {
    fun inject(activity: AuthScreenFragment)

    companion object {
        fun init(
            navigation: NavigationDependencies,
            restDependencies: RestDependencies,
            urlDependencies: UrlDependencies
        ): SkyengAuthComponent =
            DaggerSkyengAuthComponent.builder()
                .navigationDependencies(navigation)
                .authComponentProvider(
                    AuthComponentProvider.init(
                        restDependencies,
                        urlDependencies
                    )
                )
                .build()
    }
}
