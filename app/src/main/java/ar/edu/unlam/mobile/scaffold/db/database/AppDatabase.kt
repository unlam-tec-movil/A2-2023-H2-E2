package ar.edu.unlam.mobile.scaffold.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile.scaffold.db.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.db.dao.TrackDao
import ar.edu.unlam.mobile.scaffold.db.entity.Playlist
import ar.edu.unlam.mobile.scaffold.db.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.db.entity.Track

@Database(
    entities = [Playlist::class, Track::class, PlaylistTrackCrossRef::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract val trackDao: TrackDao
    abstract val playlistDao: PlaylistDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context = context.applicationContext,
                    AppDatabase::class.java,
                    "db",
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
