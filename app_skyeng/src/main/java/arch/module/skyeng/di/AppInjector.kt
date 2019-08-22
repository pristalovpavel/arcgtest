package arch.module.skyeng.di

import arch.module.login.api.SkyengAuthDependencies
import arch.module.corenavigation.api.NavigationDependencies
import arch.module.corenetwork.api.RestDependencies
import arch.module.corenetwork.api.UrlDependencies
import arch.module.skyengmain.api.SkyengMainScreenDependencies


interface AppInjector :
    SkyengAuthDependencies,
    SkyengMainScreenDependencies,
    NavigationDependencies,
    UrlDependencies,
    RestDependencies {
}
