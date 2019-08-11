package arch.module.corenetwork.api

import arch.module.corenetwork.di.NetworkModule
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