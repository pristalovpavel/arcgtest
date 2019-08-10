package arch.module.auth.di

import arch.module.auth.ui.login.AuthScreenFragment
import arch.module.corenavigation.di.PerScreen
import dagger.Component


@PerScreen
@Component
internal interface SkyengAuthComponent {
    fun inject(activity: AuthScreenFragment)

    companion object {
        fun init(/*appComponent: ApplicationProvider*/): SkyengAuthComponent =
            DaggerSkyengAuthComponent.builder()
//                .applicationProvider(appComponent)
                .build()
    }
}
