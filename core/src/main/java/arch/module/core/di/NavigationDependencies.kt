package arch.module.core.di

import arch.module.core.other.MvpRouter
import ru.terrakok.cicerone.NavigatorHolder


interface NavigationDependencies {

    fun provideNavigatorHolder(): NavigatorHolder
    fun provideMvpRouter(): MvpRouter
}