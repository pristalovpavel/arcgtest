package arch.module.core.di

import arch.module.core.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponentProvider : RestDependencies {

    companion object {
        fun init(): NetworkComponentProvider {
            return DaggerNetworkComponentProvider.create()
        }
    }
}