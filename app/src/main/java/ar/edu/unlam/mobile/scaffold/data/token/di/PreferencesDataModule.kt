package ar.edu.unlam.mobile.scaffold.data.token.di

import android.content.Context
import ar.edu.unlam.mobile.scaffold.data.token.preference.Preferences
import ar.edu.unlam.mobile.scaffold.data.token.preference.PreferencesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesDataModule {

    @Singleton
    @Provides
    fun providePreferences(@ApplicationContext app: Context): Preferences = PreferencesImpl(app)
}
