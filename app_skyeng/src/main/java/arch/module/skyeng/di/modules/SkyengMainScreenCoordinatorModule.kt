package arch.module.skyeng.di.modules

import arch.module.core.di.PerScreen
import arch.module.skyeng.ui.mainscreen.ISkyengMainScreenCoordinator
import arch.module.skyeng.ui.mainscreen.SkyengMainScreenCoordinator
import dagger.Binds
import dagger.Module


@Module
interface SkyengMainScreenCoordinatorModule {

    @Binds
    @PerScreen
    fun bindCoordinator(impl: SkyengMainScreenCoordinator): ISkyengMainScreenCoordinator
}