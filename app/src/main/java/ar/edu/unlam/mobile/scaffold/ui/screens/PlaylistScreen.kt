package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.components.lists.TypeSongElement
import ar.edu.unlam.mobile.scaffold.ui.components.others.Separator
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel
import coil.compose.AsyncImage

val tracksList = listOf<Track>(
    Track(
        "vw8vew82",
        "Revolution Radio",
        "Green Day",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Hoy Estoy Raro",
        "El Cuarteto De Nos",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Paradise",
        "Coldplay",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Paper Wings",
        "Rise Against",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "By the Way",
        "Red Hot Chili Peppers",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Toxicity",
        "System Of A Down",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Radioactive",
        "Imagine Dragons",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Numb",
        "Linkin Park",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "The Hell Song",
        "Sum 41",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
    Track(
        "vw8vew82",
        "Misery Business",
        "Paramore",
        "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
    ),
)

@Composable

fun PlaylistScreen(
    navController: NavHostController? = null,
    playlistId: String,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    var playlist = homeViewModel.tempPlaylistState.collectAsState()
    val playlists = homeViewModel.appUiState.playlistState.collectAsState()
    var imagenPlegada = remember { mutableStateOf<Boolean>(false) }
    val listState = rememberLazyListState()
    var isModalVisible by remember { mutableStateOf(false) }
    var activeSong by remember { mutableStateOf<Track?>(null) }
    val context = LocalContext.current

<<<<<<< HEAD
    fun getDataPlaylist() {
        // todo: obtener informacion de la playlist
        playlist.value = Playlist(1L, "Playlist Ejemplo", "https://picsum.photos/201", "esta es mi primer playlist",tracksList)
    }

    getDataPlaylist()

=======
>>>>>>> develop
    fun openModal(track: Track) {
        activeSong = track
        isModalVisible = true
    }

    fun removeFromPlaylist() {
        // Todo: eliminar cancion de la playlist
        val text = activeSong?.title + " fue eliminada"
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        isModalVisible = false
    }

    Box(contentAlignment = Alignment.TopCenter) {
        LaunchedEffect(listState.isScrollInProgress) {
            if (listState.isScrollInProgress) {
                Log.i("Tag", "El scroll está en progreso")
                imagenPlegada.value = true
            } else {
                imagenPlegada.value = false
            }
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            item {
                AsyncImage(
                    model = playlist,
                    contentDescription = "Imagen de muestra",
                    modifier = Modifier
                        .height(
                            if (imagenPlegada.value) {
                                120.dp
                            } else {
                                270.dp
                            },
                        )
                        .width(
                            if (imagenPlegada.value) {
                                120.dp
                            } else {
                                270.dp
                            },
                        )
                        .padding(top = 24.dp, bottom = 12.dp, end = 12.dp, start = 12.dp),
                    // .animateContentSize { initialValue, targetValue ->  }
                    contentScale = ContentScale.FillBounds,

                )
            }
            item {
<<<<<<< HEAD
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        text = playlist.value.title,
                        textAlign = TextAlign.Start,
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 10.dp),
                    )
                    Text(
                        text = playlist.value.tracks.size.toString() + " canciones",
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(vertical = 4.dp),
                    )
                    Text(
                        text = playlist.value.description,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 4.dp),
                    )
                    Separator()
                }
=======
                Text(
                    text = playlist.value.playlist.title,
                    textAlign = TextAlign.Start,
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 10.dp),
                )
                Text(
                    text = playlist.value.playlist.tracks.size.toString() + " canciones",
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 4.dp, bottom = 8.dp),
                )
                Separator()
>>>>>>> develop
            }
            items(playlist.value.playlist.tracks) { track ->
                SongElement(
                    type = TypeSongElement.ADDED,
                    track = track,
                    // playlists = playlists.value.playlists,
                    onClick = { openModal(track) },
                )
            }
        }
    }
    if (isModalVisible) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Eliminar cancion") },
            text = { Text(text = "Queres eliminar " + activeSong?.title + " de esta lista") },
            confirmButton = {
                Button(
                    onClick = {
                        removeFromPlaylist()
                    },
                    content = {
                        Text(text = "Aceptar", color = Color.White)
                    },
                )
            },
            dismissButton = {
                Button(
                    onClick = {
                        isModalVisible = false
                    },
                    content = {
                        Text(text = "Cancelar", color = Color.White)
                    },
                )
            },
        )
    }
}
