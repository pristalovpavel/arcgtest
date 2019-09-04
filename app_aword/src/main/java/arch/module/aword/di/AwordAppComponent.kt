package arch.module.aword.di

import android.content.Context
import arch.module.aword.AwordApp
import arch.module.aword.di.modules.AppSpecificDepsModule
import arch.module.aword.ui.root.AwordActivity
import arch.module.core.di.CoreComponentProvider
import arch.module.core.di.CoreDependencies
import arch.module.skyeng.di.modules.AndroidModule
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
interface AwordAppComponent : AppInjector {

    fun inject(app: AwordApp)
    fun inject(activity: AwordActivity)

    companion object {
        lateinit var appComponent: AwordAppComponent
        fun init(context: Context) {
            this.appComponent = DaggerAwordAppComponent.builder()
                .androidModule(AndroidModule(context))
                .coreDependencies(CoreComponentProvider.init())
                .build()
        }
    }
}