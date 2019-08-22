package arch.module.auth.di

import arch.module.auth.data.network.AuthRest
import arch.module.corenetwork.api.ErrorNetworkHandler
import arch.module.corenetwork.api.WordsRestUrl
import arch.module.coreutils.di.PerFeature
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class AuthModule {

    @PerFeature
    @Provides
    fun authRest(
        @ErrorNetworkHandler factory: CallAdapter.Factory,
        client: OkHttpClient,
        @WordsRestUrl url: String

    ): AuthRest = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(factory)
        .client(client)
        .build()
        .create(AuthRest::class.java)
}