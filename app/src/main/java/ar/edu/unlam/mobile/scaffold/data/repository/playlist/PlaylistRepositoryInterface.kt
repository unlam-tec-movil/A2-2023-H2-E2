package ar.edu.unlam.mobile.scaffold.data.repository.playlist

import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface PlaylistRepositoryInterface {
    fun deletePlaylist(playlistToDelete: Playlist)

    fun getAllPlaylists(): Flow<List<Playlist>>

    fun getPlaylistWithTracks(idPlaylist: Long): Flow<Playlist>

    fun insertPlaylist(playlistToInsert: Playlist)

    fun insertPlaylistWithTracks(playlistToInsert: PlaylistTrackCrossRef)

    fun removeTrackFromPlaylist(track: Track, playlist: Playlist)

    fun updatePlaylist(playlistToUpdate: Playlist)
}
