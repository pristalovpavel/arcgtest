package arch.module.core.di.modules

import arch.module.core.other.MvpRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import javax.inject.Singleton

@Module
internal class NavigationModule {

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