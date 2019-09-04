package arch.module.aword.di

import arch.module.core.di.CoreDependencies
import arch.module.core.di.UrlDependencies
import arch.module.userprofile.api.UserProfileDeps

interface AppInjector :
    CoreDependencies,
    UrlDependencies,

    UserProfileDeps