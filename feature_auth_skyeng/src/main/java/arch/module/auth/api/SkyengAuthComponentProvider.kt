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
//    @Singleton
    fun provideSkyengAuthProvider(): SkyengAuthScreenFactory =
        SkyengAuthScreenFactoryImpl()
}

@Singleton
@Component(modules = [SkyengAuthExternalModule::class])
interface SkyengAuthComponentProvider : SkyengAuthDependencies {

    companion object {

        fun init(): SkyengAuthComponentProvider {
            return DaggerSkyengAuthComponentProvider.create()
        }
    }
}