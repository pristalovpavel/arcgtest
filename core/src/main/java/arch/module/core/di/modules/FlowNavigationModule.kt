package arch.module.core.di.modules

import arch.module.core.di.PerFlow
import arch.module.core.other.MvpRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import javax.inject.Qualifier

@Module
class FlowNavigationModule {

    @PerFlow
    @Provides
    fun provideCicerone(router: FlowRouter) = Cicerone.create(router)

    @PerFlow
    @Provides
    fun provideRouter() = FlowRouter()

    @PerFlow
    @FlowNavigatorHolder
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<FlowRouter>) = cicerone.navigatorHolder
}

class FlowRouter : MvpRouter()

@Qualifier
annotation class FlowNavigatorHolder