package arch.module.skyeng.di

import android.content.Context
import arch.module.core.di.CoreComponentProvider
import arch.module.core.di.CoreDependencies
import arch.module.skyeng.SkyengApp
import arch.module.core.di.modules.AndroidModule
import arch.module.skyeng.di.modules.AppSpecificDepsModule
import arch.module.skyeng.ui.root.SkyengActivity
import arch.module.userprofile.di.ProfileModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependencies::class
    ],
    modules = [
        AndroidModule::class,
        AppSpecificDepsModule::class,

        ProfileModule::class
    ]
)
interface SkyengAppComponent : AppInjector {

    fun inject(app: SkyengApp)
    fun inject(activity: SkyengActivity)

    companion object {
        lateinit var appComponent: SkyengAppComponent
        fun init(context: Context) {
            this.appComponent = DaggerSkyengAppComponent.builder()
                .androidModule(AndroidModule(context))
                .coreDependencies(CoreComponentProvider.init())
                .build()
        }
    }
}