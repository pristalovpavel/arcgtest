package arch.module.skyengmain.di

import arch.module.corenavigation.di.PerScreen
import arch.module.skyengmain.ui.SkyengMainScreenFragment
import dagger.Component


@PerScreen
@Component
internal interface SkyengMainScreenComponent {
    fun inject(activity: SkyengMainScreenFragment)

    companion object {
        fun init(/*appComponent: ApplicationProvider*/): SkyengMainScreenComponent =
            DaggerSkyengMainScreenComponent.create()
    }
}
