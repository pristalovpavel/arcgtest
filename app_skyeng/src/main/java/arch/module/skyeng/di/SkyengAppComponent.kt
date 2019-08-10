package arch.module.skyeng.di

import android.content.Context
import arch.module.auth.api.SkyengAuthComponentProvider
import arch.module.auth.api.SkyengAuthDependencies
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenavigation.di.NavigationComponentProvider
import arch.module.skyeng.SkyengApp
import arch.module.skyeng.di.modules.AppModule
import arch.module.skyeng.ui.main.SkyengActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        SkyengAuthDependencies::class,
        NavigationDependencies::class
    ],
    modules = [
        AppModule::class
    ]
)
interface SkyengAppComponent : AppInjector {

    fun inject(app: SkyengApp)
    fun inject(activity: SkyengActivity)

    companion object {
        lateinit var appComponent: SkyengAppComponent
        fun init(context: Context) {
            this.appComponent = DaggerSkyengAppComponent.builder()
                .skyengAuthDependencies(SkyengAuthComponentProvider.init())
                .navigationDependencies(NavigationComponentProvider.init())
                .build()
        }
    }
}