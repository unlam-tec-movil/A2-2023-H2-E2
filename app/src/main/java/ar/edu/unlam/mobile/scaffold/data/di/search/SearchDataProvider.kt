package ar.edu.unlam.mobile.scaffold.data.di.search

import ar.edu.unlam.mobile.scaffold.data.interceptor.BearerTokenInterceptor
import ar.edu.unlam.mobile.scaffold.data.network.search.SearchAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchDataProvider {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(BearerTokenInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideSearchAPI(gson: Gson): SearchAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.spotify.com/")
            .client(okHttpClient)
            .build()
            .create(SearchAPI::class.java)
    }
}
