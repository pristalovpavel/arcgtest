package arch.module.skyeng.di

import arch.module.auth.api.SkyengAuthDependencies
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.skyengmain.api.SkyengMainScreenDependencies


interface AppInjector :
    SkyengAuthDependencies,
    SkyengMainScreenDependencies,
    NavigationDependencies {
}
