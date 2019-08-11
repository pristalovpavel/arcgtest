package arch.module.skyeng.di.modules

import arch.module.corenetwork.api.WordsRestUrl
import dagger.Module
import dagger.Provides


@Module
object AppSpecificDepsModule {

    @JvmStatic
    @Provides
    @WordsRestUrl
    fun provideWordsRestUrl(): String = "https://api.words.skyeng.ru/"

}