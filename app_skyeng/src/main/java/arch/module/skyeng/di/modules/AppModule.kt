package arch.module.skyeng.di.modules

import android.content.Context
import android.content.res.Resources
import arch.module.skyeng.di.AppInjector
import arch.module.skyeng.di.SkyengAppComponent.Companion.appComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    internal fun provideAppInjector(): AppInjector = appComponent

    @Provides
    @Singleton
    internal fun provideContext(): Context = context

    @Provides
    @Singleton
    internal fun provideResources(): Resources = context.resources
}