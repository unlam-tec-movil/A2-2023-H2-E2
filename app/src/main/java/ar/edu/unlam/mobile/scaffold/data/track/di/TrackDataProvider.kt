package ar.edu.unlam.mobile.scaffold.data.track.di

import ar.edu.unlam.mobile.scaffold.data.track.network.TrackAPI
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
object TrackDataProvider {
    @Provides
    @Singleton
    fun provideTrackAPI(gson: Gson): TrackAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.spotify.com/")
            .build()
            .create(TrackAPI::class.java)
    }
}
