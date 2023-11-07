package ar.edu.unlam.mobile.scaffold.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ar.edu.unlam.mobile.scaffold.db.entity.Track

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playlist: Track)

    @Delete
    fun delete(playlist: Track)

    @Update
    fun update(playlist: Track)

    @Query("SELECT * FROM track WHERE trackId=:id")
    fun get(id: Long): Track

    @Query("SELECT * FROM track")
    fun getAll(): List<Track>

    @Query("SELECT * FROM track LIMIT :limit")
    fun getAll(limit: Int): List<Track>
}
