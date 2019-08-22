package arch.module.skyengmain.di

import android.content.Context
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenavigation.di.PerScreen
import arch.module.skyengmain.ui.SkyengMainScreenFragment
import arch.module.userprofile.api.UserProfileComponentProvider
import arch.module.userprofile.api.UserProfileDeps
import dagger.Component


@PerScreen
@Component(
    dependencies = [
        NavigationDependencies::class,
        UserProfileDeps::class
    ]
)
internal interface SkyengMainScreenComponent {
    fun inject(activity: SkyengMainScreenFragment)

    companion object {
        fun init(
            context: Context,
            appComponent: NavigationDependencies
        ): SkyengMainScreenComponent {
            val userProfileDeps = UserProfileComponentProvider.init(context)

            return DaggerSkyengMainScreenComponent
                .builder()
                .navigationDependencies(appComponent)
                .userProfileDeps(userProfileDeps)
                .build()
        }
    }
}
