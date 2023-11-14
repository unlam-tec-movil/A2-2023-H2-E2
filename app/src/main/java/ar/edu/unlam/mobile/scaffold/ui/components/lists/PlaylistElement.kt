package ar.edu.unlam.mobile.scaffold.ui.components.lists

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.ui.screens.Routes
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import coil.compose.AsyncImage
import androidx.compose.runtime.*
@Composable
fun PlaylistElement (
    playlist: Playlist,
    navController: NavController,
    modifier:Modifier = Modifier,
    viewModel: PlaylistViewModel = hiltViewModel()
){

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    fun onPlaylistClick() {
        navController.navigate(
            route = Routes.PlaylistScreen.name + "/" + playlist.id,
        )
    }

    fun confirmDelete (){

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.onPrimaryContainer)
            .fillMaxWidth()
            .then(modifier.clickable { onPlaylistClick() }),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = playlist.image,
                contentDescription = "Album cover",
                modifier = modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(50.dp),
            )
            Column(modifier = modifier.padding(end = 5.dp)) {
                Text(
                    modifier = Modifier.size(width = 200.dp, height = 20.dp),
                    text = playlist.title,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Text(
                    modifier = Modifier.size(width = 200.dp, height = 20.dp),
                    text = playlist.tracks.size.toString() + " canciones",
                    color = Color(0XFFE1E1E1),
                    style = MaterialTheme.typography.labelMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }
        IconButton(
            onClick = {
                navController.navigate(
                    route = Routes.CreatePlaylist.name + "/" + playlist.id,
                )
            },
            modifier = Modifier
                .padding(end = 10.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primary)
                .size(30.dp),
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_edit_24
                ),
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(18.dp),
            )
        }
        IconButton(
            onClick = {
                showDialog = true
            },
            modifier = Modifier
                .padding(end = 10.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primary)
                .size(30.dp),
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_delete_24
                ),
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(18.dp),
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text("Eliminar playlist ${playlist.title}?")
            },
            confirmButton = {
                // Botón de confirmación
                Button(onClick = {
                    viewModel.deletePlaylist(playlist)
                    Toast.makeText( context, "${playlist.title} eliminada correctamente", Toast.LENGTH_SHORT).show()
                    showDialog = false
                }) {
                    Text("Aceptar",
                        color = Color.White)
                }
            },
            dismissButton = {
                // Botón para cerrar el cuadro de diálogo
                Button(onClick = {
                    showDialog = false
                }) {
                    Text("Cancelar",
                        color = Color.White)
                }
            }
        )
    }
}