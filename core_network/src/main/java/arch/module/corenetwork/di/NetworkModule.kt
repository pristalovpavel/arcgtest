package arch.module.corenetwork.di

import arch.module.corenetwork.api.ErrorNetworkHandler
import arch.module.corenetwork.data.OkHttpConfigurator
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun okhttp(): OkHttpClient = OkHttpConfigurator.invoke()
        .addInterceptor(OkHttpConfigurator.createLogger())
        .build()

    @ErrorNetworkHandler
    @Singleton
    @Provides
    fun errorHandler(): CallAdapter.Factory = object : CallAdapter.Factory() {
        override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
//            RxJava2CallAdapterFactory.createWithScheduler(scheduler)
//            val callAdapter = original.get(returnType, annotations, retrofit) ?: return null

            return null
        }
    }
}