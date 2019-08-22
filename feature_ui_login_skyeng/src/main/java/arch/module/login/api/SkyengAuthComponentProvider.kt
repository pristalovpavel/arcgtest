package arch.module.login.api

import arch.module.login.ui.SkyengAuthScreenFactory
import arch.module.login.ui.SkyengAuthScreenFactoryImpl
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