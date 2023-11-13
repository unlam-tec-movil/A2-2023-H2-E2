package ar.edu.unlam.mobile.scaffold.ui.viewmodels

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

data class PlaylistUiState(
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
    val error: String = ""
)

@HiltViewModel
class PlaylistViewModel @Inject constructor(private val playlistRepository: PlaylistRepository) :
    ViewModel() {

    private val _playlistUiState: MutableStateFlow<PlaylistUiState> =
        MutableStateFlow(PlaylistUiState())
    val playlistUiState = _playlistUiState.asStateFlow()

    private val _allPlaylistUiState: MutableStateFlow<AllPlaylistUiState> =
        MutableStateFlow(AllPlaylistUiState())
    val allPlaylistUiState = _allPlaylistUiState

    init {
        loadAllPlaylists()
    }

    fun loadPlaylist(idPlaylist: Long) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                playlistRepository.getPlaylistWithTracks(idPlaylist).catch {
                    _playlistUiState.value = PlaylistUiState(error = it.message.orEmpty())
                }.collect {
                    _playlistUiState.value = PlaylistUiState(playlist = it, isLoading = false)
                }
            }
        }
    }
    fun addPlaylist(playlist: Playlist) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                playlistRepository.insertPlaylist(
                    playlist
                )
            }
        }
    }

    private fun loadAllPlaylists() {
        viewModelScope.launch {
            playlistRepository.getAllPlaylists().catch {
                _allPlaylistUiState.value = AllPlaylistUiState(error = it.message.orEmpty())
            }.collect {
                _allPlaylistUiState.value = AllPlaylistUiState(playlists = it, isLoading = false)
            }
        }
    }
}