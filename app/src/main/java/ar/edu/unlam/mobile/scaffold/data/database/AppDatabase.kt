package ar.edu.unlam.mobile.scaffold.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile.scaffold.data.database.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.data.database.dao.TrackDao
import ar.edu.unlam.mobile.scaffold.data.database.entity.Playlist
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.database.entity.Track
import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepository

@Database(
    entities = [Playlist::class, Track::class, PlaylistTrackCrossRef::class],
    version = 2,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPlaylistDao(): PlaylistDao
    abstract fun getTrackDao(): TrackDao

    /* TODO: Ver si se saca
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
     */
}
