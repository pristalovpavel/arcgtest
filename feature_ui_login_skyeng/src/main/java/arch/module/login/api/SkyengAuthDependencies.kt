package arch.module.login.api

import arch.module.login.ui.SkyengAuthScreenFactory


interface SkyengAuthDependencies {

    fun provideSkyengAuthScreenFactory(): SkyengAuthScreenFactory
}