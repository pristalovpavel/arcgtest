package arch.module.corenetwork.api

import arch.module.corenetwork.data.TokenHolder
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import javax.inject.Qualifier

@Qualifier
annotation class WordsRestUrl

@Qualifier
annotation class ErrorNetworkHandler

interface RestDependencies {

    fun provideTokenHolder(): TokenHolder

    fun provideOkHttpClient(): OkHttpClient

    @ErrorNetworkHandler
    fun provideErrorNetworkHandler(): CallAdapter.Factory
}

interface UrlDependencies {
    @WordsRestUrl
    fun provideWordsRestUrl(): String
}