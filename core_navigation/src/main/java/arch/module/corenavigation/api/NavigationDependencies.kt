package arch.module.corenavigation.api

import arch.module.corenavigation.MvpRouter
import ru.terrakok.cicerone.NavigatorHolder


interface NavigationDependencies {

    fun provideNavigatorHolder(): NavigatorHolder
    fun provideMvpRouter(): MvpRouter
}