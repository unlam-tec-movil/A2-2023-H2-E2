package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.database.dao.TrackDao
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.domain.services.search.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.services.track.TrackGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
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

data class TrackUiState(
    val tracks: List<Track> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

data class SimpleTrackUiState(
    val track: Track = Track("", "", "", ""),
    val loading: Boolean = true,
    val error: String = "",
)

data class RecommendationUiState(
    val tracks: List<Track> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

// TODO: Borrar despues, hago esto xq franco no tiene lo suyo hecho todavia
data class PlaylistState(
    val playlist: Playlist = Playlist(0, "", "", "", listOf()),
    val error: String = "",
)

// Conjunto de todos los states para achicar la cantidad de argumentos pasados a los composables
data class AppUiState(
    // val playlistState: StateFlow<PlaylistUIState>,
    val trendsState: StateFlow<TrendsUIState>,
    val trackState: StateFlow<TrackUiState>,
    val simpleTrackState: StateFlow<SimpleTrackUiState>,
    val recommendationState: StateFlow<RecommendationUiState>,
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchGetter: SearchGetter,
    private val trackGetter: TrackGetter,
    private val trackDao: TrackDao,
    // private val playlistDao: PlaylistDao,
) : ViewModel() {
    // private val _playlistUiState = MutableStateFlow(PlaylistUIState())
    private val _trendsUiState = MutableStateFlow(TrendsUIState())
    private val _trackUiState = MutableStateFlow(TrackUiState())
    private val _recommendationUiState = MutableStateFlow(RecommendationUiState())
    private val _simpleTrackUiState = MutableStateFlow(SimpleTrackUiState())
    private val _playlistState = MutableStateFlow(PlaylistState())

    val tempPlaylistState = _playlistState.asStateFlow()

    val appUiState = AppUiState(
        // playlistState = _playlistUiState.asStateFlow(),
        trendsState = _trendsUiState.asStateFlow(),
        trackState = _trackUiState.asStateFlow(),
        simpleTrackState = _simpleTrackUiState.asStateFlow(),
        recommendationState = _recommendationUiState.asStateFlow(),
    )

    init {
        // getPlaylists()
        getTrendingTracks()
        getRecommendations()
        /*
        var tracks = listOf(
            ar.edu.unlam.mobile.scaffold.data.database.entity.Track(
                "3RiPr603aXAoi4GHyXx0uy",
                "Hymn for the Weekend",
                "Coldplay",
                "https://i.scdn.co/image/ab67616d0000b2738ff7c3580d429c8212b9a3b6",
            ),
            ar.edu.unlam.mobile.scaffold.data.database.entity.Track(
                "09mEdoA6zrmBPgTEN5qXmN",
                "Call Out My Name",
                "The Weeknd",
                "https://i.scdn.co/image/ab67616d0000b273bb9b84cecfc41da3b8c7d74b",
            ),
            ar.edu.unlam.mobile.scaffold.data.database.entity.Track(
                "1xsYj84j7hUDDnTTerGWlH",
                "Dream On",
                "Aerosmith",
                "https://i.scdn.co/image/ab67616d0000b273b11078ee23dcd99e085ac33e",
            ),
            ar.edu.unlam.mobile.scaffold.data.database.entity.Track(
                "6Qyc6fS4DsZjB2mRW9DsQs",
                "Iris",
                "The Goo Goo Dolls",
                "https://i.scdn.co/image/ab67616d0000b273eda9478c39a21e1cdc6609ca",
            ),
            ar.edu.unlam.mobile.scaffold.data.database.entity.Track(
                "4gbVRS8gloEluzf0GzDOFc",
                "Maps",
                "Maroon 5",
                "https://i.scdn.co/image/ab67616d0000b2730f90927dac93624396fbfb96",
            ),
        )
        var playlist = Playlist(
            playlistId = 1,
            image = "",
            name = "TestDePlaylist",
            description = "Playlist de prueba",
        )
        playlistDao.insert(playlist)
        for (track in tracks) {
            var tablaIntermedia = PlaylistTrackCrossRef(1, track.spotifyId)
            playlistDao.insertPlaylistWithTracks(tablaIntermedia)
        }
         */
    }

    fun getTrackBySearchBar(query: String) {
        viewModelScope.launch {
            searchGetter.getSearchResults(query = query)
                .catch {
                    Log.i("Error en la llamada de api", "${it.message}")
                    _trackUiState.value = TrackUiState(error = it.message.orEmpty())
                }
                .collect { tracks ->
                    _trackUiState.value = TrackUiState(tracks = tracks)
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
/*
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
    }*/
}
