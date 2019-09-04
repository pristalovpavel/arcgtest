package arch.module.core.di

import arch.module.core.di.modules.NavigationModule
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