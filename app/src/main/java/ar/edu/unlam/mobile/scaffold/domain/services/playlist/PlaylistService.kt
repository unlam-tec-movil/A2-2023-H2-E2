package ar.edu.unlam.mobile.scaffold.domain.services.playlist

import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepositoryInterface
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaylistService @Inject constructor(private val playlistRepositoryImpl: PlaylistRepositoryInterface) :
    PlaylistGetter, PlaylistSetter {
    override fun getAllPlaylists(): Flow<List<Playlist>> {
        return this.playlistRepositoryImpl.getAllPlaylists()
    }

    override fun getPlaylistWithTracks(idPlaylist: Long): Flow<Playlist> {
        return this.playlistRepositoryImpl.getPlaylistWithTracks(idPlaylist)
    }

    override fun deletePlaylist(playlistToDelete: Playlist) {
        this.playlistRepositoryImpl.deletePlaylist(playlistToDelete)
    }

    override fun insertPlaylist(playlistToInsert: Playlist) {
        this.playlistRepositoryImpl.insertPlaylist(playlistToInsert)
    }

    override fun insertPlaylistWithTracks(playlistToInsert: PlaylistTrackCrossRef) {
        this.playlistRepositoryImpl.insertPlaylistWithTracks(playlistToInsert)
    }

    override fun removeTrackFromPlaylist(track: Track, playlist: Playlist) {
        this.playlistRepositoryImpl.removeTrackFromPlaylist(track = track, playlist = playlist)
    }

    override fun updatePlaylist(playlistToUpdate: Playlist) {
        this.playlistRepositoryImpl.updatePlaylist(playlistToUpdate = playlistToUpdate)
    }
}
