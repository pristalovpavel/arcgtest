package arch.module.skyeng.di

import arch.module.login.api.SkyengAuthDependencies
import arch.module.core.di.NavigationDependencies
import arch.module.core.di.RestDependencies
import arch.module.core.di.UrlDependencies
import arch.module.skyengmain.api.SkyengMainScreenDependencies


interface AppInjector :
    SkyengAuthDependencies,
    SkyengMainScreenDependencies,
    NavigationDependencies,
    UrlDependencies,
    RestDependencies {
}
