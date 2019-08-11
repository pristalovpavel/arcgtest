package arch.module.skyengmain.api

import arch.module.skyengmain.ui.SkyengMainScreenFactory


interface SkyengMainScreenDependencies {

    fun provideSkyengMainScreenFactory(): SkyengMainScreenFactory
}