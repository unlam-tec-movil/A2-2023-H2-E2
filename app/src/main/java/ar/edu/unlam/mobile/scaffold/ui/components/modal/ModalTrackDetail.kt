package ar.edu.unlam.mobile.scaffold.ui.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.ui.components.others.Separator
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import coil.compose.AsyncImage
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun convertirSegundosAMinutosYSegundos(milisegundos: String): String {
    val segundos = milisegundos.toInt() / 1000
    val minutos = (segundos % 3600) / 60
    val segundosRestantes = segundos % 60

    return "$minutos min. y $segundosRestantes seg."
}
fun convertirFechaAFormatoDeseado(fecha: String): String {
    val formatoEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formatoSalida = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", Locale("es", "ES"))

    val fechaLocal = LocalDate.parse(fecha, formatoEntrada)
    return fechaLocal.format(formatoSalida)
}

@Composable
fun ModalTrackDetail(
    onClose: () -> Unit,
    trackId: String,
    playlistViewModel: PlaylistViewModel = hiltViewModel(),
) {
    val fullTrack = playlistViewModel.trackUiState.collectAsState()
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    val screenWidthDp = configuration.screenWidthDp

    LaunchedEffect(Unit) {
        playlistViewModel.getAPITrack(trackId)
    }

    Dialog(
        onDismissRequest = { onClose() },
    ) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background((MaterialTheme.colorScheme.onPrimaryContainer))
                .padding(16.dp)
                .height(((screenHeightDp * 0.75)).dp)
                .width((screenWidthDp * 0.7).dp),
        ) {
            AsyncImage(
                model = fullTrack.value.track.image,
                contentDescription = "Imagen de cancion",
                modifier = Modifier
                    .height(290.dp)
                    .width(290.dp),
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = fullTrack.value.track.title,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 8.dp),
            )
            Separator()
            Text(
                text = "Lanzamiento: " + fullTrack.value.track.releaseDate,
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 8.dp),
            )
            Text(
                text = "Duracion: " + convertirSegundosAMinutosYSegundos(fullTrack.value.track.duration.toString()),
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 8.dp),
            )
            Text(
                text = "Album: " + fullTrack.value.track.album,
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp),
            )
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                items(fullTrack.value.track.artists) { artist ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        AsyncImage(
                            model = artist.image,
                            contentDescription = "imagen artista",
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            contentScale = ContentScale.FillBounds,
                        )
                        Text(
                            text = artist.name,
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = 6.dp),
                        )
                    }
                }
            }
        }
    }
}
