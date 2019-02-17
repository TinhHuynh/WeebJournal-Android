package harrycoder.github.com.weebjournal.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import harrycoder.github.com.weebjournal.BuildConfig
import harrycoder.github.com.weebjournal.data.network.WjApi
import harrycoder.github.com.weebjournal.data.repository.PostRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The [RepositoryModule] provides objects needed for network requests
 */

private const val SERVER_URL = "https://api.themoviedb.org/3/"

@Module
class RepositoryModule {

    /**
     * Provide an [OkHttpClient] with an interceptor, that adds an api key to every request for
     * backend authorization.
     * In debug builds we also add a [HttpLoggingInterceptor] for debugging purposes.
     */
    @Provides
    @Reusable
    fun providesOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            client.addInterceptor(loggingInterceptor)
        }

        return client.build()
    }

    /**
     * Provide a [Retrofit] interface for the given [SERVER_URL]
     */
    @Provides
    @Reusable
    fun providesRetrofitClient(okHttpClient: OkHttpClient): WjApi {
        return Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(WjApi::class.java)
    }

    /**
     * Provide the [TmdbApi] for network requests
     */
    @Provides
    @Reusable
    fun providePostRepository(tmdbApi: WjApi): PostRepository {
        return PostRepository(tmdbApi)
    }
}