package arch.module.auth.di.module

import arch.module.auth.ui.login.IAuthCoordinator
import arch.module.auth.ui.login.SkyengAuthCoordinator
import arch.module.core.di.PerScreen
import dagger.Binds
import dagger.Module


@Module
interface AuthCoordinatorModule {

    @Binds
    @PerScreen
    fun bindCoordinator(impl: SkyengAuthCoordinator): IAuthCoordinator
}