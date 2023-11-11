package ar.edu.unlam.mobile.scaffold.data.songs.di

import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchDataProvider {
    @Provides
    @Singleton
    fun provideSearchAPI(gson: Gson): SongsAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.spotify.com/")
            .build()
            .create(SongsAPI::class.java)
    }
}
