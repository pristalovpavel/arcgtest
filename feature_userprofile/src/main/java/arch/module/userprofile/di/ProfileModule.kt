package arch.module.userprofile.di

import arch.module.corenetwork.api.ErrorNetworkHandler
import arch.module.corenetwork.api.WordsRestUrl
import arch.module.userprofile.data.network.UserProfileRest
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ProfileModule {

    //    @Singleton
    @Provides
    fun userProfileRest(
        @ErrorNetworkHandler factory: CallAdapter.Factory,
        client: OkHttpClient,
        @WordsRestUrl url: String
    ): UserProfileRest = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(factory)
        .client(client)
        .build()
        .create(UserProfileRest::class.java)

}