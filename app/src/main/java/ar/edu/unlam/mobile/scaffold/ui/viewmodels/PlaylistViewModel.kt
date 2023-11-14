package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepository
import ar.edu.unlam.mobile.scaffold.data.repository.track.TrackDefaultRepository
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.FullTrack
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class CurrentPlaylistUiState(
    val playlist: Playlist = Playlist(
        0,
        "",
        "",
        "",
        emptyList(),
    ),
    val isLoading: Boolean = true,
    val error: String = "",
)

data class CurrentTrackUiState(
    val track: FullTrack = FullTrack(
        "",
        "",
        listOf(),
        "",
        "",
        "",
        0L,
    ),
    val isLoading: Boolean = true,
    val error: String = "",
)

data class AllPlaylistUiState(
    val playlists: List<Playlist> = emptyList(),
    val isLoading: Boolean = true,
    val error: String = "",
)

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val playlistRepository: PlaylistRepository,
    private val trackRepository: TrackDefaultRepository,
) : ViewModel() {

    private val _playlistUiState: MutableStateFlow<CurrentPlaylistUiState> =
        MutableStateFlow(CurrentPlaylistUiState())
    val playlistUiState = _playlistUiState.asStateFlow()

    private val _allPlaylistUiState: MutableStateFlow<AllPlaylistUiState> =
        MutableStateFlow(AllPlaylistUiState())
    val allPlaylistUiState = _allPlaylistUiState.asStateFlow()

    private val _trackUiState: MutableStateFlow<CurrentTrackUiState> =
        MutableStateFlow(CurrentTrackUiState())
    val trackUiState = _trackUiState.asStateFlow()

    init {
        loadAllPlaylists()
    }

    fun loadPlaylist(idPlaylist: Long) {
        Log.i("load", "load playlist")
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.getPlaylistWithTracks(idPlaylist)
                    .catch {
                        _playlistUiState.value =
                            _playlistUiState.value.copy(error = it.message.orEmpty())
                    }
                    .collect {
                        _playlistUiState.value =
                            _playlistUiState.value.copy(playlist = it, isLoading = false)
                    }
            }
        }
    }

    fun insertPlaylist(playlist: Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.insertPlaylist(
                    playlist,
                )
            }
        }
    }

    fun insertPlaylistWithTracks(playlist: PlaylistTrackCrossRef) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.insertPlaylistWithTracks(playlist)
            }
        }
    }

    fun updatePlaylist(playlist: Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.updatePlaylist(
                    playlist,
                )
            }
        }
    }

    fun deletePlaylist(playlist: Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.deletePlaylist(
                    playlist,
                )
            }
        }
    }

    private fun loadAllPlaylists() {
        viewModelScope.launch {
            playlistRepository.getAllPlaylists().catch {
                _allPlaylistUiState.value =
                    _allPlaylistUiState.value.copy(error = it.message.orEmpty())
            }.collect {
                _allPlaylistUiState.value =
                    _allPlaylistUiState.value.copy(playlists = it, isLoading = false)
            }
        }
    }

    fun insertTrack(track: Track) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                trackRepository.insertTrack(track)
            }
        }
    }

    fun removeTrack(track: Track, playlist: Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.removeTrackFromPlaylist(track, playlist)
            }
        }
    }

    fun getAPITrack(id: String) {
        Log.i("full track", "entroooo")
        viewModelScope.launch {
            Log.i("full track", "en el lauch")
            trackRepository.getAPITrack(id)
                .catch {
                    Log.i("full track", it.message.toString())
                    _trackUiState.value = _trackUiState.value.copy(error = it.message.orEmpty())
                }
                .collect {
                    Log.i("full track", it.title)
                    _trackUiState.value = _trackUiState.value.copy(track = it, isLoading = false)
                }
        }
    }
}
