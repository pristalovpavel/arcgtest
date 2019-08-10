package arch.module.auth.di

import arch.module.auth.ui.login.AuthScreenFragment
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenavigation.di.PerScreen
import dagger.Component


@PerScreen
@Component(dependencies = [NavigationDependencies::class])
internal interface SkyengAuthComponent {
    fun inject(activity: AuthScreenFragment)

    companion object {
        fun init(appComponent: NavigationDependencies): SkyengAuthComponent =
            DaggerSkyengAuthComponent.builder()
                .navigationDependencies(appComponent)
                .build()
    }
}
