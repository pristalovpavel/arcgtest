package arch.module.skyeng.di

import arch.module.corenavigation.di.NavigationModule
import arch.module.skyeng.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NavigationModule::class
    ]
)
interface SkyengAppComponent {

}