package ar.edu.unlam.mobile.scaffold.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.data.authorization.AuthorizationAPI
import ar.edu.unlam.mobile.scaffold.domain.kitty.services.KittyGetter
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_CREDENTIALS
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_ID
import ar.edu.unlam.mobile.scaffold.utils.constans.CLIENT_SECRET
import ar.edu.unlam.mobile.scaffold.utils.retrofit.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*@Immutable
sealed interface HomescreenUiState {
    data class Success(val message: String = "") : HomescreenUiState
    object Loading : HomescreenUiState
    data class Error(val message: String) : HomescreenUiState
}

data class HomeUIState(
    val homescreenUiState: HomescreenUiState = HomescreenUiState.Loading,
)
*/


@HiltViewModel
class HomeViewModel @Inject constructor(val kittyGetter: KittyGetter) : ViewModel() {
    // Mutable State Flow contiene un objeto de estado mutable. Simplifica la operación de actualización de
    // información y de manejo de estados de una aplicación: Cargando, Error, Éxito.
    // (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
    // _Kitty State es el estado del componente "Kitty" inicializado como "Cargando"

   /*
    private val _kittyState = MutableStateFlow(HomescreenUiState.Loading)

    // Ui State es el estado general del view model.
    private val _uiState = MutableStateFlow(
        HomeUIState(_kittyState.value),
    )

    // UI expone el estado anterior como un Flujo de Estado de solo lectura.
    // Esto impide que se pueda modificar el estado desde fuera del ViewModel.
    val uiState = _uiState.asStateFlow()
*/


    init {
        getAuthorization()
    }


    private fun getAuthorization() {
        viewModelScope.launch {
            val baseUrl = "https://accounts.spotify.com/"
            val response =
                RetrofitInstance(baseUrl)
                    .getRetrofit()
                    .create(AuthorizationAPI::class.java)
                    .getAuthorization(CLIENT_CREDENTIALS, CLIENT_ID, CLIENT_SECRET)

            val bodyResponse = response.body()

            if (response.isSuccessful) {
                Log.i("TOKEN de respuesta", "${bodyResponse?.accessToken}")
                Log.i("Tipo de token de respuesta", "${bodyResponse?.tokenType}")

            } else {
                Log.i("FALLA TOKEN API", "NO se obtuvo respuesta")
                val codeError = response.code()
                Log.i("FALLA TOKEN API", "Código de error: $codeError")
            }
        }
    }
}
