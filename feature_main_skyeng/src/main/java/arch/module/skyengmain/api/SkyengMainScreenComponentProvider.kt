package arch.module.skyengmain.api

import arch.module.skyengmain.ui.SkyengMainScreenFactory
import arch.module.skyengmain.ui.SkyengMainScreenFactoryImpl
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SkyengMainScreenModule {
    @Provides
    @Singleton
    fun provideSkyengMainScreenFactory(): SkyengMainScreenFactory =
        SkyengMainScreenFactoryImpl()
}

@Singleton
@Component(modules = [SkyengMainScreenModule::class])
interface SkyengMainScreenComponentProvider : SkyengMainScreenDependencies {

    companion object {

        fun init(): SkyengMainScreenComponentProvider {
            return DaggerSkyengMainScreenComponentProvider.create()
        }
    }
}