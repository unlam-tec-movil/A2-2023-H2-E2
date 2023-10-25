package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse
import ar.edu.unlam.mobile.scaffold.data.authorization.network.AuthorizationAPI
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SearchGetter
import ar.edu.unlam.mobile.scaffold.domain.songs.service.SongsGetter
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_CREDENTIALS
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_ID
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_SECRET
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

data class SongsUIState(
    val songs: List<Song> = emptyList(),
    val loading: Boolean = true,
    val error: String = "",
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    val searchGetter: SearchGetter,
    val songsGetter: SongsGetter,
) : ViewModel() {

    // Mutable State Flow contiene un objeto de estado mutable. Simplifica la operación de actualización de
    // información y de manejo de estados de una aplicación: Cargando, Error, Éxito.
    // (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
    // _Kitty State es el estado del componente "Kitty" inicializado como "Cargando"

    private val _songUiState = MutableStateFlow(SongsUIState())
    private val _playlistUiState = MutableStateFlow(PlaylistUIState())

    // UI expone el estado anterior como un Flujo de Estado de solo lectura.
    // Esto impide que se pueda modificar el estado desde fuera del ViewModel.
    val playlistUiState = _playlistUiState.asStateFlow()

    val songUIState = _songUiState.asStateFlow()

    init {
        // getAuthorization()
        getTrendingSongs()
    }

    private fun getTrendingSongs() {
        viewModelScope.launch {
            songsGetter.getTrendingSongs()
                .catch {
                    _songUiState.value = _songUiState.value.copy(error = it.message ?: "Error")
                }
                .collect {
                    _songUiState.value = _songUiState.value.copy(songs = it, loading = false)
                }
        }
    }

    // Todo, borrar
    //    private fun getSearchResults() {
    //        viewModelScope.launch {
    //            val accessToken = getAuthorization()
    //
    //            if (accessToken != "Error") {
    //                searchGetter.getSearchResults("Nirvana", accessToken = "Bearer $accessToken")
    //                    .collect {
    //                        _uiState.value = HomeUIState(PlaylistUIState.Success(it))
    //                        Log.i("Search API Model", it.toString())
    //                    }
    //            } else {
    //                Log.i("Access Token", accessToken)
    //            }
    //        }
    //    }

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
                val codeError = response.code()
                Log.i("FALLA TOKEN API", "Código de error: $codeError")
            }
        }

        return bodyResponse?.accessToken ?: "Error"
    }
}
