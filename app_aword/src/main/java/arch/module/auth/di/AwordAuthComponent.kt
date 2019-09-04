package arch.module.auth.di

import android.content.Context
import arch.module.auth.di.module.AuthCoordinatorModule
import arch.module.auth.ui.login.AuthScreenFragment
import arch.module.core.di.*
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
interface AwordAuthComponent {
    fun inject(activity: AuthScreenFragment)

    companion object {
        fun init(
           context: Context
        ): AwordAuthComponent =
            DaggerAwordAuthComponent.builder()
                .navigationDependencies(context.findComponentDependencies())
                .restDependencies(context.findComponentDependencies())
                .urlDependencies(context.findComponentDependencies())
                .userProfileDeps(context.findComponentDependencies())
                .build()
    }
}
