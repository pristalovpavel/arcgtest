package arch.module.skyeng.di

import arch.module.core.di.NavigationDependencies
import arch.module.core.di.RestDependencies
import arch.module.core.di.UrlDependencies

interface AppInjector :
    NavigationDependencies,
    UrlDependencies,
    RestDependencies