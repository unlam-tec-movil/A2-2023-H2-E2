package ar.edu.unlam.mobile.scaffold.domain.services.playlist

import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

interface PlaylistSetter {

    fun deletePlaylist(playlistToDelete: Playlist)

    fun insertPlaylist(playlistToInsert: Playlist)

    fun insertPlaylistWithTracks(playlistToInsert: PlaylistTrackCrossRef)

    fun removeTrackFromPlaylist(track: Track, playlist: Playlist)

    fun updatePlaylist(playlistToUpdate: Playlist)
}
