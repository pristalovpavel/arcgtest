package arch.module.skyeng.di

import android.content.Context
import arch.module.core.di.CoreDependencies
import arch.module.core.di.PerScreen
import arch.module.core.di.findComponentDependencies
import arch.module.skyeng.di.modules.SkyengMainScreenCoordinatorModule
import arch.module.userprofile.api.UserProfileDeps
import dagger.Component


@PerScreen
@Component(
    dependencies = [
        CoreDependencies::class,
        UserProfileDeps::class
    ],
    modules = [
        SkyengMainScreenCoordinatorModule::class
    ]
)
internal interface SkyengMainScreenComponent {
    fun inject(activity: arch.module.skyeng.ui.mainscreen.SkyengMainScreenFragment)

    companion object {
        fun init(
            context: Context,
            appComponent: CoreDependencies
        ): SkyengMainScreenComponent {
            return DaggerSkyengMainScreenComponent
                .builder()
                .coreDependencies(appComponent)
                .userProfileDeps(context.findComponentDependencies())
                .build()
        }
    }
}
