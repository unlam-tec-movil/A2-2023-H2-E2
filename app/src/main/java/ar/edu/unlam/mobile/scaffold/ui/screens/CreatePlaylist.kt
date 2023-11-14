package ar.edu.unlam.mobile.scaffold.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.texts.Title
import ar.edu.unlam.mobile.scaffold.ui.theme.Blue73
import ar.edu.unlam.mobile.scaffold.ui.theme.DisableButtonColorPlaylist
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import coil.compose.AsyncImage

var imagenesMuestra = listOf<String>(
    "https://picsum.photos/200",
    "https://picsum.photos/111",
    "https://picsum.photos/208",
    "https://picsum.photos/201",
    "https://picsum.photos/204",
    "https://picsum.photos/205",
    "https://picsum.photos/100",
)

fun obtenerImagenesPlaylist(track: List<Track>): List<String> {
    var playlistsObtenidas = listOf<String>()
    track.map { it ->
        playlistsObtenidas.plus(it.image)
    }
    return playlistsObtenidas
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreatePlaylist(
    navController: NavHostController,
    playlistId: String,
    playlistViewModel: PlaylistViewModel = hiltViewModel(),
) {
    val playlist = playlistViewModel.playlistUiState.collectAsState()
    var textNameInput by remember { mutableStateOf("") }
    var textDescriptionInput by remember { mutableStateOf("") }
    var idPlaylist by remember { mutableStateOf<Long?>(null) }
    var srcImage by remember { mutableStateOf("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTw0zKknEf_ExsMDMYCkGnkF4bvK-dRrBJb9FdYBJOO0vy5H15IsJSpMBSlVDz7bt6BKCk&usqp=CAU") }

    var isModalImagesVisible by remember { mutableStateOf(false) }
    var imagesPlaceholder by remember { mutableStateOf(imagenesMuestra) }
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    val screenWidthDp = configuration.screenWidthDp
    val context = LocalContext.current

    fun changeImagePlaylist(image: String) {
        srcImage = image
        isModalImagesVisible = false
    }

    fun savePlaylist() {
        if (playlistId != "0") {
            playlistViewModel.updatePlaylist(
                Playlist(
                    id = idPlaylist,
                    title = textNameInput,
                    description = textDescriptionInput,
                    image = srcImage,
                ),
            )
        } else {
            playlistViewModel.insertPlaylist(
                Playlist(
                    title = textNameInput,
                    description = textDescriptionInput,
                    image = srcImage,
                ),
            )
        }
        navController.popBackStack()
        Toast.makeText(context, R.string.playlist_created, Toast.LENGTH_SHORT).show()
    }
    LaunchedEffect(Unit) {
        playlistViewModel.loadPlaylist(playlistId.toString().toLong())
    }

    LaunchedEffect(playlist.value.playlist) {
        textNameInput = playlist.value.playlist.title
        textDescriptionInput = playlist.value.playlist.description
        idPlaylist = playlist.value.playlist.id
        if (playlist.value.playlist.image != "") srcImage = playlist.value.playlist.image
        if (playlist.value.playlist.tracks.size > 0) {
            imagesPlaceholder =
                imagesPlaceholder + obtenerImagenesPlaylist(playlist.value.playlist.tracks)
        }
    }

    Box(contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Title(
                modifier = Modifier.padding(top = 18.dp),
                title = stringResource(
                    id =
                    if (playlistId != "0") R.string.update_list_title else R.string.create_list_title,
                ),
            )

            Spacer(modifier = Modifier.height(45.dp))

            AsyncImage(
                model = srcImage,
                contentDescription = "Imagen de muestra",
                modifier = Modifier
                    .height(290.dp)
                    .width(290.dp),
                contentScale = ContentScale.FillBounds,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.End,
            ) {
                IconButton(
                    onClick = { isModalImagesVisible = true },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_edit_24),
                        contentDescription = "Cargar imagen",
                        tint = Color.White,
                    )
                }
            }

            Spacer(modifier = Modifier.height(45.dp))

            val localManager = LocalSoftwareKeyboardController.current
            val textFieldColor = Color.White
            val containerColor = Blue73
            TextField(
                value = textNameInput,
                onValueChange = { textNameInput = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = containerColor,
                    focusedContainerColor = containerColor,
                    focusedTextColor = textFieldColor,
                    unfocusedTextColor = textFieldColor,
                    disabledLabelColor = textFieldColor,
                    focusedLabelColor = textFieldColor,
                ),
                label = { Text(text = "Nombre", color = textFieldColor) },
                singleLine = true,
                maxLines = 1,
                keyboardActions = KeyboardActions(
                    onDone = { localManager?.hide() },
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(35.dp))

            TextField(
                value = textDescriptionInput,
                onValueChange = { textDescriptionInput = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = containerColor,
                    focusedContainerColor = containerColor,
                    focusedTextColor = textFieldColor,
                    unfocusedTextColor = textFieldColor,
                    disabledLabelColor = textFieldColor,
                    focusedLabelColor = textFieldColor,

                ),
                singleLine = true,
                maxLines = 1,
                keyboardActions = KeyboardActions(
                    onDone = { localManager?.hide() },
                ),
                label = { Text(text = "Descripción", color = textFieldColor) },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(35.dp))

            var buttonEnabled by remember { mutableStateOf(false) }

            buttonEnabled = textNameInput != "" && textDescriptionInput != ""

            Button(
                enabled = buttonEnabled,
                onClick = {
                    savePlaylist()
                },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = textFieldColor,
                    disabledContainerColor = DisableButtonColorPlaylist,
                ),
            ) {
                Text(text = "Guardar", fontSize = 27.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "Guardar lista",
                    modifier = Modifier.size(33.dp),
                )
            }
        }
    }

    if (isModalImagesVisible) {
        Dialog(
            onDismissRequest = { isModalImagesVisible = false },
        ) {
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background((MaterialTheme.colorScheme.onPrimaryContainer))
                    .padding(16.dp)
                    .height(((screenHeightDp * 0.8)).dp)
                    .width((screenWidthDp * 0.85).dp),
            ) {
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                ) {
                    items(imagenesMuestra) { imagen ->
                        Box(
                            modifier = Modifier.clickable { changeImagePlaylist(imagen) },
                        ) {
                            AsyncImage(
                                model = imagen,
                                contentDescription = "Imagen de muestra",
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .height(150.dp)
                                    .width(150.dp),
                                contentScale = ContentScale.FillBounds,
                            )
                        }
                    }
                }
            }
        }
    }
}
