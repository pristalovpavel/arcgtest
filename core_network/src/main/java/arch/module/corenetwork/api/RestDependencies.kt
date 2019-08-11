package arch.module.corenetwork.api

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import javax.inject.Qualifier

@Qualifier
annotation class WordsRestUrl

@Qualifier
annotation class ErrorNetworkHandler

interface RestDependencies {

//    @WordsRestUrl
//    fun provideWordsRestUrl(): String


    fun provideOkHttpClient(): OkHttpClient

    @ErrorNetworkHandler
    fun provideErrorNetworkHandler(): CallAdapter.Factory
}