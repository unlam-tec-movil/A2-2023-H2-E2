package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.database.dao.PlaylistDao
import ar.edu.unlam.mobile.scaffold.data.database.dao.TrackDao
import ar.edu.unlam.mobile.scaffold.data.repository.playlist.PlaylistRepository
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.domain.services.search.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.services.track.TrackGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class PlaylistUIState(
    val playlists: List<Playlist> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

data class TrendsUIState(
    val tracks: List<Track> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

data class TrackUIState(
    val tracks: List<Track> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

data class SimpleTrackUIState(
    val track: Track = Track("", "", "", ""),
    val loading: Boolean = true,
    val error: String = "",
)

data class RecommendationUiState(
    val tracks: List<Track> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

// Conjunto de todos los states para achicar la cantidad de argumentos pasados a los composables
data class AppUiState(
    val playlistState: StateFlow<PlaylistUIState>,
    val trendsState: StateFlow<TrendsUIState>,
    val trackState: StateFlow<TrackUIState>,
    val simpleTrackState: StateFlow<SimpleTrackUIState>,
    val recommendationState: StateFlow<RecommendationUiState>,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchGetter: SearchGetter,
    private val trackGetter: TrackGetter,
    private val trackDao: TrackDao,
    private val playlistDao: PlaylistDao,
) : ViewModel() {
    private val _playlistUiState = MutableStateFlow(PlaylistUIState())
    private val _trendsUiState = MutableStateFlow(TrendsUIState())
    private val _trackUiState = MutableStateFlow(TrackUIState())
    private val _recommendationUiState = MutableStateFlow(RecommendationUiState())
    private val _simpleTrackUiState = MutableStateFlow(SimpleTrackUIState())

    val appUiState = AppUiState(
        playlistState = _playlistUiState.asStateFlow(),
        trendsState = _trendsUiState.asStateFlow(),
        trackState = _trackUiState.asStateFlow(),
        simpleTrackState = _simpleTrackUiState.asStateFlow(),
        recommendationState = _recommendationUiState.asStateFlow(),
    )

    init {
        getPlaylists()
        getTrendingTracks()
        getRecommendations()
    }

    fun getTrackBySearchBar(query: String) {
        viewModelScope.launch {
            searchGetter.getSearchResults(query = query)
                .catch {
                    Log.i("Error en la llamada de api", "${it.message}")
                    _trackUiState.value = TrackUIState(error = it.message.orEmpty())
                }
                .collect { tracks ->
                    _trackUiState.value = TrackUIState(tracks = tracks)
                }
        }
    }

    private fun getTrendingTracks() {
        viewModelScope.launch {
            trackGetter.getTrendingTracks()
                .catch {
                    _trendsUiState.value = _trendsUiState.value.copy(error = it.message ?: "Error")
                }
                .collect {
                    _trendsUiState.value = _trendsUiState.value.copy(tracks = it, loading = false)
                }
        }
    }

    private fun getRecommendations() {
        viewModelScope.launch {
            trackGetter.getRecommendations()
                .catch {
                    _recommendationUiState.value =
                        _recommendationUiState.value.copy(error = it.message ?: "Error")
                }
                .collect {
                    _recommendationUiState.value =
                        _recommendationUiState.value.copy(tracks = it, loading = false)
                }
        }
    }

    private fun getPlaylists() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                PlaylistRepository(playlistDao = playlistDao).getAllPlaylists()
                    .catch {
                        _playlistUiState.value =
                            _playlistUiState.value.copy(error = it.message ?: "Error")
                    }
                    .collect {
                        _playlistUiState.value =
                            _playlistUiState.value.copy(playlists = it, loading = false)
                    }
            }
        }
    }
}
