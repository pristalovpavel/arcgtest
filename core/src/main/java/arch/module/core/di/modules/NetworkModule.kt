package arch.module.core.di.modules

import arch.module.core.di.ErrorNetworkHandler
import arch.module.core.usecase.data.other.TokenHolder
import arch.module.core.other.OkHttpConfigurator
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun okhttp(tokenHolder: TokenHolder): OkHttpClient = OkHttpConfigurator.invoke(tokenHolder)
        .addInterceptor(OkHttpConfigurator.createLogger())
        .build()

    @ErrorNetworkHandler
    @Singleton
    @Provides
    fun errorHandler(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
//    fun errorHandler(): CallAdapter.Factory = object : CallAdapter.Factory() {
//        override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
//
////            val callAdapter = original.get(returnType, annotations, retrofit) ?: return null
//
//            return null
//        }
//    }
}