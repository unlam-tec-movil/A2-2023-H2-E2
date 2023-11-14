package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepository
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
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

data class AllPlaylistUiState(
    val playlists: List<Playlist> = emptyList(),
    val isLoading: Boolean = true,
    val error: String = "",
)

@HiltViewModel
class PlaylistViewModel @Inject constructor(private val playlistRepository: PlaylistRepository) :
    ViewModel() {

    private val _playlistUiState: MutableStateFlow<CurrentPlaylistUiState> =
        MutableStateFlow(CurrentPlaylistUiState())
    val playlistUiState = _playlistUiState.asStateFlow()

    private val _allPlaylistUiState: MutableStateFlow<AllPlaylistUiState> =
        MutableStateFlow(AllPlaylistUiState())
    val allPlaylistUiState = _allPlaylistUiState

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

    fun addPlaylist(playlist: Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.insertPlaylist(
                    playlist,
                )
            }
        }
    }

    fun updatePlaylist(playlist:Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.update(
                    playlist,
                )
            }
        }
    }

    fun deletePlaylist(playlist:Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.delete(
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
}
