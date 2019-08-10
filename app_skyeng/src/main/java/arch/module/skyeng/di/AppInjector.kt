package arch.module.skyeng.di

import arch.module.auth.api.SkyengAuthDependencies
import arch.module.corenavigation.api.NavigationDependencies


interface AppInjector :
    SkyengAuthDependencies,
    NavigationDependencies {

}
