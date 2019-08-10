package arch.module.skyeng.di

import android.content.Context
import arch.module.auth.api.SkyengAuthComponentExternal
import arch.module.auth.api.SkyengAuthProvider
import arch.module.corenavigation.di.NavigationModule
import arch.module.skyeng.SkyengApp
import arch.module.skyeng.di.modules.AppModule
import arch.module.skyeng.ui.main.SkyengActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [SkyengAuthProvider::class],
    modules = [
        AppModule::class,
        NavigationModule::class
    ]
)
interface SkyengAppComponent : AppInjector {

    fun inject(app: SkyengApp)
    fun inject(activity: SkyengActivity)

    companion object {
        lateinit var appComponent: SkyengAppComponent
        fun init(context: Context) {
            this.appComponent = DaggerSkyengAppComponent.builder()
                .appModule(AppModule(context))
                .skyengAuthProvider(SkyengAuthComponentExternal.init())
                .build()
        }
    }
}