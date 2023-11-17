package ar.edu.unlam.mobile.scaffold.data.repository.playlist

import ar.edu.unlam.mobile.scaffold.data.database.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val playlistDao: PlaylistDao,
) : PlaylistRepositoryInterface {
    override fun getAllPlaylists(): Flow<List<Playlist>> {
        val response = playlistDao.getAllPlaylistsWithTracks()
        return response.map { playlist -> playlist.map { currentPlaylist -> currentPlaylist.toDomainPlaylist() } }
    }

    override fun insertPlaylist(playlistToInsert: Playlist) {
        playlistDao.insert(playlistToInsert.toPlaylistEntity())
    }

    override fun deletePlaylist(playlistToDelete: Playlist) {
        playlistDao.delete(playlistToDelete.toPlaylistEntity())
    }

    override fun updatePlaylist(playlistToUpdate: Playlist) {
        playlistDao.update(playlistToUpdate.toPlaylistEntity())
    }

    override fun getPlaylistWithTracks(idPlaylist: Long): Flow<Playlist> {
        return playlistDao.getPlaylistsWithTracks(idPlaylist)
            .map { playlistWithTracks -> playlistWithTracks.toDomainPlaylist() }
    }

    override fun insertPlaylistWithTracks(playlistToInsert: PlaylistTrackCrossRef) {
        playlistDao.insertPlaylistWithTracks(playlistToInsert)
    }

    override fun removeTrackFromPlaylist(track: Track, playlist: Playlist) {
        playlistDao.removeTrackFromPlaylist(track.spotifyId, playlist.id!!)
    }
}
