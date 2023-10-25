package ar.edu.unlam.mobile.scaffold.ui.components.others
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MySnackBar(active: Boolean = true, text: String = "") {
    val coroutineScope = rememberCoroutineScope()
    var snackbarVisible by remember { mutableStateOf(false) }

    fun showSnackbar() {
        snackbarVisible = true
        coroutineScope.launch {
            // Espera unos segundos antes de ocultar el Snackbar
            delay(3000)
            snackbarVisible = false
        }
    }

    Column {
        // Contenido de tu pantalla

        // Botón para mostrar el Snackbar
        Button(onClick = { showSnackbar() }) {
            Text("Mostrar Snackbar")
        }

        // SnackbarHost para mostrar el Snackbar
        SnackbarHost(hostState = remember { SnackbarHostState() }, modifier = Modifier.padding(16.dp)) {
            // Muestra el Snackbar cuando snackbarVisible es true
            if (snackbarVisible) {
                Snackbar(
                    content = {
                        Text("¡Snackbar mostrado!")
                    },
                    action = {
                        TextButton(
                            onClick = {
                                snackbarVisible = false
                            },
                        ) {
                            Text("Cerrar")
                        }
                    },
                )
            }
        }
    }
}
