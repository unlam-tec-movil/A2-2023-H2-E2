package ar.edu.unlam.mobile.scaffold.data.repository.playlist

import ar.edu.unlam.mobile.scaffold.data.database.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.toDomainPlaylist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val playlistDao: PlaylistDao,
) {
    suspend fun getAllPlaylists(): Flow<List<Playlist>> {
        val response = playlistDao.getAllPlaylistsWithTracks()
        return response.map { it.map { it.toDomainPlaylist() } }
    }
}
