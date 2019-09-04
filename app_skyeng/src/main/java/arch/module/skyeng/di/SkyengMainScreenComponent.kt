package arch.module.skyeng.di

import android.content.Context
import arch.module.core.di.NavigationDependencies
import arch.module.core.di.PerScreen
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
    fun inject(activity: arch.module.skyeng.ui.mainscreen.SkyengMainScreenFragment)

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
