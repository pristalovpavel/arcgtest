package arch.module.auth.di.module

import arch.module.auth.ui.login.AwordAuthCoordinator
import arch.module.auth.ui.login.IAuthCoordinator
import arch.module.core.di.PerScreen
import dagger.Binds
import dagger.Module


@Module
interface AuthCoordinatorModule {

    @Binds
    @PerScreen
    fun bindCoordinator(impl: AwordAuthCoordinator): IAuthCoordinator
}