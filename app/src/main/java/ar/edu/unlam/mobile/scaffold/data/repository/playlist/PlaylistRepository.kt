package ar.edu.unlam.mobile.scaffold.data.repository.playlist

import ar.edu.unlam.mobile.scaffold.data.database.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistWithTracks
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.toDomainPlaylist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val playlistDao: PlaylistDao,
) {
    fun getAllPlaylists(): Flow<List<Playlist>> {
        val response = playlistDao.getAllPlaylistsWithTracks()
        return response.map { it.map { it.toDomainPlaylist() } }
    }

    fun insertPlaylist(playlistToInsert: Playlist) {
        playlistDao.insert(playlistToInsert.toPlaylistEntity())
    }

    fun delete(playlistToDelete: Playlist) {
        playlistDao.delete(playlistToDelete.toPlaylistEntity())
    }

    fun update(playlistToUpdate: Playlist) {
        playlistDao.update(playlistToUpdate.toPlaylistEntity())
    }

    fun getPlaylistWithTracks(idPlaylist: Long): Flow<Playlist>{
        return playlistDao.getPlaylistsWithTracks(idPlaylist).map { it.toDomainPlaylist() }
    }

    fun getAllPlaylistWithTracks(limit: Int): Flow<List<Playlist>> {
        return playlistDao.getAllPlaylistsWithTracks(limit).map { it.map { it.toDomainPlaylist() } }
    }


}
