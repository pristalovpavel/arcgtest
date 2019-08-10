package arch.module.auth.api

import arch.module.auth.ui.SkyengAuthScreenFactory


interface SkyengAuthProvider {

    fun provideSkyengAuthScreenFactory(): SkyengAuthScreenFactory
}