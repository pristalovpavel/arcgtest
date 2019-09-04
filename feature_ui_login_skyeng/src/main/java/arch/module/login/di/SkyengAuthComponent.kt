package arch.module.login.di

import arch.module.auth.di.AuthComponentProvider
import arch.module.core.di.NavigationDependencies
import arch.module.core.di.RestDependencies
import arch.module.core.di.UrlDependencies
import arch.module.core.di.PerScreen
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
