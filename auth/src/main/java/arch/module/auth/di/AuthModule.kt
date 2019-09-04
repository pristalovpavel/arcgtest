package arch.module.auth.di

import arch.module.auth.usecase.data.network.AuthRest
import arch.module.core.di.ErrorNetworkHandler
import arch.module.core.di.PerScreen
import arch.module.core.di.WordsRestUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class AuthModule {

    @PerScreen
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