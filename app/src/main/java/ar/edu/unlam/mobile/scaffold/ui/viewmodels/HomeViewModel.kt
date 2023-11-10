package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.token.repository.TokenPreferenceRepository
import ar.edu.unlam.mobile.scaffold.domain.authorization.services.AuthorizationGetter
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import ar.edu.unlam.mobile.scaffold.domain.track.services.TrackGetter
import ar.edu.unlam.mobile.scaffold.utils.constants.AuthorizationConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PlaylistUIState(
    val playlist: List<Song> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

data class TrendsUIState(
    val tracks: List<Track> = listOf(Track("", "", ""), Track("", "", "")),
    val loading: Boolean = true,
    val error: String = "",
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    val searchGetter: SearchGetter,
    val trackGetter: TrackGetter,
    val authorizationGetter: AuthorizationGetter,
    private val preferenceRepository: TokenPreferenceRepository
) : ViewModel() {
    private val _playlistUiState = MutableStateFlow(PlaylistUIState())
    private val _trendsUiState = MutableStateFlow(TrendsUIState())
    val playlistUiState = _playlistUiState.asStateFlow()
    val trendsUiState = _trendsUiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAuthorization()
            getTrendingTracks(authorizationGetter)
        }
    }

    private suspend fun getTrendingTracks(authorizationGetter: AuthorizationGetter) {
        trackGetter.getTrendingTracks(authorizationGetter).catch {
            _trendsUiState.value = _trendsUiState.value.copy(error = it.message ?: "Error")
        }.collect {
            _trendsUiState.value = _trendsUiState.value.copy(tracks = it, loading = false)
        }
    }

    private suspend fun getAuthorization() {
        authorizationGetter.getAuthorization(
            AuthorizationConstants.CLIENT_CREDENTIALS,
            AuthorizationConstants.CLIENT_ID,
            AuthorizationConstants.CLIENT_SECRET
        ).catch {
            Log.i("ERROR AL OBTENER EL TOKEN", it.toString())
        }.collect {
            preferenceRepository.setToken("token", it.accessToken)
        }
    }
}
