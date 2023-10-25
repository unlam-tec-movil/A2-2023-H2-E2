package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.components.lists.TypeSongElement

val fakePlaylist2 = Playlist(9, "Finde", "asd", listOf())

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true, backgroundColor = 0xFF111124L, showSystemUi = true)
@Composable
fun PlaylistScreen() {
    var imagenPlegada = remember { mutableStateOf<Boolean>(false) }
    val listState = rememberLazyListState()
    var isModalVisible by remember { mutableStateOf(false) }
    var activeSong by remember { mutableStateOf<Song?>(null) }

    fun openModal(song: Song) {
        activeSong = song
        isModalVisible = true
    }

    fun removeFromPlaylist() {
        // eliminar cancion de la playlist
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
                Image(
                    // TODO: cambiar el painterResource por el verdadero
                    painter = painterResource(R.drawable.album_bubbles),
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
                        .padding(vertical = 20.dp, horizontal = 12.dp),
                    // .animateContentSize { initialValue, targetValue ->  }
                    contentScale = ContentScale.FillBounds,

                )
            }
            items(exampleSongs) { song ->
                SongElement(type = TypeSongElement.ADDED, song = song) {
                    openModal(song)
                }
            }
        }
    }
    if (isModalVisible) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = "Eliminar cancion") },
            text = { Text(text = "Queres eliminar esta cancion de esta lista") },
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
