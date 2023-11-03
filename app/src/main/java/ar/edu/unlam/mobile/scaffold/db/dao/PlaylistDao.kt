package ar.edu.unlam.mobile.scaffold.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ar.edu.unlam.mobile.scaffold.db.entity.Playlist

@Dao
interface PlaylistDao {
    @Insert
    fun insert(playlist: Playlist)

    @Delete
    fun delete(playlist: Playlist)

    @Update
    fun update(playlist: Playlist)

    @Query("SELECT * FROM playlist WHERE id=:id")
    fun get(id: Long): Playlist

    @Query("SELECT * FROM playlist")
    fun getAll(): List<Playlist>

    @Query("SELECT * FROM playlist LIMIT :limit")
    fun getAll(limit: Int): List<Playlist>
}
