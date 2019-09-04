package arch.module.aword.di.modules

import arch.module.aword.ui.welcome.IWelcomeCoordinator
import arch.module.aword.ui.welcome.WelcomeCoordinator
import arch.module.core.di.PerScreen
import dagger.Binds
import dagger.Module


@Module
interface WelcomeModule {

    @Binds
    @PerScreen
    fun bindCoordinator(impl: WelcomeCoordinator): IWelcomeCoordinator
}