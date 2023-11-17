package ar.edu.unlam.mobile.scaffold.domain.services.playlist

import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import kotlinx.coroutines.flow.Flow

interface PlaylistGetter {
    fun getAllPlaylists(): Flow<List<Playlist>>

    fun getPlaylistWithTracks(idPlaylist: Long): Flow<Playlist>
}
