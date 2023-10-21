package ar.edu.unlam.mobile.scaffold.data.search.di

import ar.edu.unlam.mobile.scaffold.data.search.network.SearchAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object SearchDataProvider {
    @Provides
    @Singleton
    fun provideSearchAPI(gson: Gson): SearchAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.spotify.com/v1/")
            .build()
            .create(SearchAPI::class.java)
    }
}
