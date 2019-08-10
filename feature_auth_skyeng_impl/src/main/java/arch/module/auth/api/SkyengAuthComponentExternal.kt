package arch.module.auth.api

import arch.module.auth.ui.SkyengAuthScreenFactory
import arch.module.auth.ui.SkyengAuthScreenFactoryImpl
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SkyengAuthExternalModule {
    @Provides
    fun provideSkyengAuthProvider(): SkyengAuthScreenFactory =
        SkyengAuthScreenFactoryImpl()
}

@Singleton
@Component(modules = [SkyengAuthExternalModule::class])
interface SkyengAuthComponentExternal : SkyengAuthProvider {

    companion object {

        fun init(): SkyengAuthComponentExternal {

            return DaggerSkyengAuthComponentExternal.builder()
//                .mainToolsProvider(mainToolsProvider)
                .build()
        }
    }
}