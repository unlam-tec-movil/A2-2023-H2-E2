package ar.edu.unlam.mobile.scaffold.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import ar.edu.unlam.mobile.scaffold.data.database.entity.Playlist
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistWithTracks
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaylistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playlist: Playlist)

    @Delete
    fun delete(playlist: Playlist)

    @Update
    fun update(playlist: Playlist)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaylistWithTracks(playlist: PlaylistTrackCrossRef)
    @Transaction
    @Query("SELECT * FROM playlist where playlistId=:id")
        fun getPlaylistsWithTracks(id: Long): Flow<PlaylistWithTracks>

    @Transaction
    @Query("SELECT * FROM playlist")
    fun getAllPlaylistsWithTracks(): Flow<List<PlaylistWithTracks>>

    @Transaction
    @Query("SELECT * FROM playlist LIMIT :limit")
    fun getAllPlaylistsWithTracks(limit: Int): Flow<List<PlaylistWithTracks>>

    // @Transaction
    // @Query("DELETE FROM playlist WHERE spotifyId =:trackId")
    // fun removeTrack(trackId: String)
}
