package ar.edu.unlam.mobile.scaffold.data.authorization.di

import ar.edu.unlam.mobile.scaffold.data.authorization.network.AuthorizationAPI
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
class AuthorizationDataProvider {
    @Provides
    @Singleton
    fun provideAuthorizationAPI(gson: Gson): AuthorizationAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://accounts.spotify.com/")
            .build()
            .create(AuthorizationAPI::class.java)
    }
}
