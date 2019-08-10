package arch.module.skyengmain.di

import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenavigation.di.PerScreen
import arch.module.skyengmain.ui.SkyengMainScreenFragment
import dagger.Component


@PerScreen
@Component(dependencies = [NavigationDependencies::class])
internal interface SkyengMainScreenComponent {
    fun inject(activity: SkyengMainScreenFragment)

    companion object {
        fun init(appComponent: NavigationDependencies): SkyengMainScreenComponent =
            DaggerSkyengMainScreenComponent
                .builder()
                .navigationDependencies(appComponent)
                .build()
    }
}
