package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse
import ar.edu.unlam.mobile.scaffold.data.authorization.network.AuthorizationAPI
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import ar.edu.unlam.mobile.scaffold.domain.track.services.TrackGetter
import ar.edu.unlam.mobile.scaffold.utils.constants.CLIENT_CREDENTIALS
import ar.edu.unlam.mobile.scaffold.utils.constants.CLIENT_ID
import ar.edu.unlam.mobile.scaffold.utils.constants.CLIENT_SECRET
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

data class PlaylistUIState(
    val playlist: List<Song> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

data class TrendsUIState(
    val tracks: List<Track> = listOf(Track("", "", "", ""), Track("", "", "", "")),
    val loading: Boolean = true,
    val error: String = "",
)

data class TrackUiState(
    val tracks: List<Track> = emptyList(),
    val loading: Boolean = true,
    val error: String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    val searchGetter: SearchGetter,
    val trackGetter: TrackGetter,
) : ViewModel() {
    private val _playlistUiState = MutableStateFlow(PlaylistUIState())
    private val _trendsUiState = MutableStateFlow(TrendsUIState())
    private val _trackUiState = MutableStateFlow(TrackUiState())

    val playlistUiState = _playlistUiState.asStateFlow()
    val trendsUiState = _trendsUiState.asStateFlow()
    val trackUiState = _trackUiState.asStateFlow()

    init {
        // getAuthorization()
        getTrendingTracks()
    }

    fun getTrackBySearchBar(query: String) {
        viewModelScope.launch {
            searchGetter.getSearchResults(query = query)
                .catch {
                    Log.i("Error en la llamada de api", "")
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

    fun getAuthorization(): String {
        var bodyResponse: AuthorizationResponse? = null
        viewModelScope.launch {
            val baseUrl = "https://accounts.spotify.com/"
            val response =
                Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(AuthorizationAPI::class.java)
                    .getAuthorization(CLIENT_CREDENTIALS, CLIENT_ID, CLIENT_SECRET)

            bodyResponse = response.body()

            if (response.isSuccessful) {
                Log.i("TOKEN de respuesta", "${bodyResponse?.accessToken}")
                Log.i("Tipo de token de respuesta", "${bodyResponse?.tokenType}")
            } else {
                Log.i("FALLA TOKEN API", "NO se obtuvo respuesta")
            }
        }

        return bodyResponse?.accessToken ?: "Error"
    }
}
