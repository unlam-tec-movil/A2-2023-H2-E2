package ar.edu.unlam.mobile.scaffold.data.repository.playlist

import ar.edu.unlam.mobile.scaffold.data.database.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.toDomainPlaylist
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val playlistDao: PlaylistDao,
) {
    suspend fun getAllPlaylists(): List<Playlist> {
        val response = playlistDao.getAllPlaylistsWithTracks()
        return response.map { it.toDomainPlaylist() }
    }
}
