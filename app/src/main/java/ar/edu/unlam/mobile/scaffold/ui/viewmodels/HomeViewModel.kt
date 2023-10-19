package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.authorization.AuthorizationAPI
import ar.edu.unlam.mobile.scaffold.data.authorization.AuthorizationResponse
import ar.edu.unlam.mobile.scaffold.data.search.network.SearchApiModel

import ar.edu.unlam.mobile.scaffold.domain.search.service.SearchGetter
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_CREDENTIALS
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_ID
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_SECRET

import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Inject


sealed interface HomescreenUiState {
    data class Success(val searchModel: SearchApiModel) : HomescreenUiState
    object Loading : HomescreenUiState
    data class Error(val message: String) : HomescreenUiState
}

data class HomeUIState(
    val homescreenUiState: HomescreenUiState = HomescreenUiState.Loading,
)


@HiltViewModel
class HomeViewModel @Inject constructor(val searchGetter: SearchGetter) : ViewModel() {

    // Mutable State Flow contiene un objeto de estado mutable. Simplifica la operación de actualización de
    // información y de manejo de estados de una aplicación: Cargando, Error, Éxito.
    // (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
    // _Kitty State es el estado del componente "Kitty" inicializado como "Cargando"


    private val _searchUiState = MutableStateFlow(HomescreenUiState.Loading)

    // Ui State es el estado general del view model.
    private val _uiState = MutableStateFlow(
        HomeUIState(_searchUiState.value),
    )

    // UI expone el estado anterior como un Flujo de Estado de solo lectura.
    // Esto impide que se pueda modificar el estado desde fuera del ViewModel.
    val uiState = _uiState.asStateFlow()


    init {
        //getAuthorization()
        getSearchResults()
    }


    private fun getSearchResults() {
        viewModelScope.launch {
            val accessToken = getAuthorization()

            if (accessToken != "Error") {
                searchGetter.getSearchResults("Nirvana", accessToken = "Bearer $accessToken")
                    .collect {
                        _uiState.value = HomeUIState(HomescreenUiState.Success(it))
                        Log.i("Search API Model", it.toString())
                    }
            } else {
                Log.i("Access Token", accessToken)
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
                val codeError = response.code()
                Log.i("FALLA TOKEN API", "Código de error: $codeError")
            }
        }

        return bodyResponse?.accessToken ?: "Error"
    }
}
