package arch.module.aword.di.modules

import arch.module.core.di.WordsRestUrl
import dagger.Module
import dagger.Provides


@Module
object AppSpecificDepsModule {

    @JvmStatic
    @Provides
    @WordsRestUrl
    fun provideWordsRestUrl(): String = "https://api.words.skyeng.ru/"

}