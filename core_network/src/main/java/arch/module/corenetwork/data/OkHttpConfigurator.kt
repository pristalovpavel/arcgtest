package arch.module.corenetwork.data

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


object OkHttpConfigurator {
    private const val TIMEOUT_SECONDS = 80


    operator fun invoke(token: TokenHolder): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val authorization = token.getAuthorization()
            val request = chain.request()
            var builderRequest: Request.Builder = request.newBuilder()

            val original = builderRequest.build()
            val auth = original
                .headers["Authorization"]

            val hasAuth = auth != null && !auth.isEmpty()


            builderRequest = builderRequest
//                .addHeader("Skyeng-Mobile-App-Version", BuildConfig.VERSION_NAME)
//                .addHeader("Skyeng-Mobile-App-Id", BuildConfig.SUBSCRIPTION_APP_ID)
//                .addHeader("appId", BuildConfig.SUBSCRIPTION_APP_ID)

            if (authorization != null && !hasAuth) {

                builderRequest = builderRequest
                    .addHeader("Authorization", authorization!!)
            }
            val proceed = chain.proceed(builderRequest.build())
            val headers = proceed.headers
//            preferences.setLastServerTime(headers.getDate("Date"))
            proceed
        }
        builder.connectTimeout(TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        return builder
    }

    fun createLogger(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

}