package arch.module.core.di

import arch.module.core.di.modules.NavigationModule
import arch.module.core.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class,
        NavigationModule::class
    ]

)
interface CoreComponentProvider : CoreDependencies {

    companion object {
        fun init(): CoreComponentProvider {
            return DaggerCoreComponentProvider.create()
        }
    }
}