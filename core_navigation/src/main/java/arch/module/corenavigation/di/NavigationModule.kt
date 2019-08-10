package arch.module.corenavigation.di

import arch.module.corenavigation.MvpRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideCicerone(router: MvpRouter) = Cicerone.create(router)

    @Singleton
    @Provides
    fun provideRouter() = MvpRouter()

    @Singleton
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<MvpRouter>) = cicerone.navigatorHolder
}