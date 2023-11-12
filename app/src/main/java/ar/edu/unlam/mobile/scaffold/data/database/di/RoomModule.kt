package ar.edu.unlam.mobile.scaffold.data.database.di

import android.content.Context
import androidx.room.Room
import ar.edu.unlam.mobile.scaffold.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "spotilist"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePlaylistDao(db: AppDatabase) = db.getPlaylistDao()

    @Singleton
    @Provides
    fun provideTrackDao(db: AppDatabase) = db.getTrackDao()
}
