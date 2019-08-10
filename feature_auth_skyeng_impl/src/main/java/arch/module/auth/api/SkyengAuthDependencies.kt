package arch.module.auth.api

import arch.module.auth.ui.SkyengAuthScreenFactory


interface SkyengAuthDependencies {

    fun provideSkyengAuthScreenFactory(): SkyengAuthScreenFactory
}