package arch.module.skyeng.di

import android.content.Context
import arch.module.auth.api.SkyengAuthComponentProvider
import arch.module.auth.api.SkyengAuthDependencies
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenavigation.di.NavigationComponentProvider
import arch.module.skyeng.SkyengApp
import arch.module.skyeng.di.modules.AppModule
import arch.module.skyeng.ui.main.SkyengActivity
import arch.module.skyengmain.api.SkyengMainScreenComponentProvider
import arch.module.skyengmain.api.SkyengMainScreenDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        SkyengAuthDependencies::class,
        NavigationDependencies::class,
        SkyengMainScreenDependencies::class
    ],
    modules = [
        AppModule::class
    ]
)
interface SkyengAppComponent : AppInjector {

    fun inject(app: SkyengApp)
    fun inject(activity: SkyengActivity)

    fun provideAppInjector(): AppInjector

    companion object {
        lateinit var appComponent: SkyengAppComponent
        fun init(context: Context) {
            this.appComponent = DaggerSkyengAppComponent.builder()
                .appModule(AppModule(context))
                .skyengAuthDependencies(SkyengAuthComponentProvider.init())
                .skyengMainScreenDependencies(SkyengMainScreenComponentProvider.init())
                .navigationDependencies(NavigationComponentProvider.init())
                .build()
        }
    }
}