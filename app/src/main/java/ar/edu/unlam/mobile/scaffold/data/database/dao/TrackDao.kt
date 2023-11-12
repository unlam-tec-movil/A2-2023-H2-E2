package ar.edu.unlam.mobile.scaffold.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ar.edu.unlam.mobile.scaffold.data.database.entity.Track

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playlist: Track)

    @Delete
    fun delete(playlist: Track)

    @Update
    fun update(playlist: Track)

    @Query("SELECT * FROM track WHERE spotifyId=:id")
    fun get(id: String): Track

    @Query("SELECT * FROM track")
    fun getAll(): List<Track>

    @Query("SELECT * FROM track LIMIT :limit")
    fun getAll(limit: Int): List<Track>
}
