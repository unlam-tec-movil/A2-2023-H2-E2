package ar.edu.unlam.mobile.scaffold.ui.viewmodels

/*data class PlaylistUiState(
    val playlist: Playlist = Playlist(
        0,
        "",
        "",
        "",
        emptyList(),
    ),
    val loading: Boolean = true,
    val error: String = "",
)

@HiltViewModel
class PlaylistViewModel @Inject constructor(private val playlistRepository: PlaylistRepository) :
    ViewModel() {

    private val _playlistUiState: MutableStateFlow<PlaylistUiState> =
        MutableStateFlow(PlaylistUiState())

    val playlistUiState = _playlistUiState.asStateFlow()

    fun getAllPlaylists(idPlaylist: Long) {
        viewModelScope.launch {
            playlistRepository.getPlaylistWithTracks(idPlaylist).catch {
                _playlistUiState.value = PlaylistUiState(error = it.message.orEmpty())
            }.collect {
                _playlistUiState.value = PlaylistUiState(playlist = it, loading = false)
            }
        }
    }
}
*/
