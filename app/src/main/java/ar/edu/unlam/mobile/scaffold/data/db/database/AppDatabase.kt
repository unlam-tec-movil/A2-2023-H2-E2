package ar.edu.unlam.mobile.scaffold.data.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile.scaffold.data.db.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.data.db.dao.TrackDao
import ar.edu.unlam.mobile.scaffold.data.db.entity.Playlist
import ar.edu.unlam.mobile.scaffold.data.db.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.db.entity.Track

@Database(
    entities = [Playlist::class, Track::class, PlaylistTrackCrossRef::class],
    version = 2,
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
                    "listify",
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
