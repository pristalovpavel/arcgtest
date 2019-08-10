package arch.module.corenavigation.di

import arch.module.corenavigation.api.NavigationDependencies
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [NavigationModule::class]
)
interface NavigationComponentProvider : NavigationDependencies {

    companion object {
        fun init(): NavigationComponentProvider {
            return DaggerNavigationComponentProvider.create()
        }
    }
}