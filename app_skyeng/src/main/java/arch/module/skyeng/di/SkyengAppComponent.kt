package arch.module.skyeng.di

import android.content.Context
import arch.module.core.di.NavigationComponentProvider
import arch.module.core.di.NavigationDependencies
import arch.module.core.di.NetworkComponentProvider
import arch.module.core.di.RestDependencies
import arch.module.skyeng.SkyengApp
import arch.module.skyeng.di.modules.AppModule
import arch.module.skyeng.di.modules.AppSpecificDepsModule
import arch.module.skyeng.ui.root.SkyengActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        NavigationDependencies::class,
        RestDependencies::class
    ],
    modules = [
        AppModule::class,
        AppSpecificDepsModule::class
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
                .navigationDependencies(NavigationComponentProvider.init())
                .restDependencies(NetworkComponentProvider.init())
                .build()
        }
    }
}