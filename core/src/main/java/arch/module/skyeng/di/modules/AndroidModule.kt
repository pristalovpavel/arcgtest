package arch.module.skyeng.di.modules

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AndroidModule(
    private val context: Context
) {

    @Provides
    @Singleton
    internal fun provideContext(): Context = context

    @Provides
    @Singleton
    internal fun provideResources(): Resources = context.resources
}