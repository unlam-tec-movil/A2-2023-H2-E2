package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.components.lists.TypeSongElement
import ar.edu.unlam.mobile.scaffold.ui.components.others.Separator
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import coil.compose.AsyncImage

@Composable
fun PlaylistScreen(
    playlistId: String,
    playlistViewModel: PlaylistViewModel = hiltViewModel(),
) {
    val playlist = playlistViewModel.playlistUiState.collectAsState()
    val recommendations = playlistViewModel.recommendationUiState.collectAsState()
    val imagenPlegada = remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    var isModalVisible by remember { mutableStateOf(false) }
    var activeTrack by remember { mutableStateOf(Track("", "", "", "")) }

    fun openModal(track: Track) {
        activeTrack = track
        isModalVisible = true
    }

    fun removeFromPlaylist(track: Track) {
        playlistViewModel.removeTrack(track, playlist.value.playlist)
        isModalVisible = false
    }

    fun addToPlaylist(track: Track) {
        playlistViewModel.insertTrack(track)
        val intermediateTableRow =
            PlaylistTrackCrossRef(playlist.value.playlist.id!!, track.spotifyId)
        playlistViewModel.insertPlaylistWithTracks(intermediateTableRow)
    }

    Box(contentAlignment = Alignment.TopCenter) {
        LaunchedEffect(Unit) {
            playlistViewModel.loadPlaylist(playlistId.toLong())
            playlistViewModel.getRecommendations()
        }
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
                    model = playlist.value.playlist.image,
                    contentDescription = stringResource(id = R.string.sample_image),
                    modifier = Modifier
                        .animateContentSize()
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
                    contentScale = ContentScale.FillBounds,
                )
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        text = playlist.value.playlist.title,
                        textAlign = TextAlign.Start,
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 10.dp),
                    )
                    Text(
                        text = stringResource(
                            id = R.string.total_tracks,
                            playlist.value.playlist.tracks.size.toString(),
                        ),
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp),
                    )
                    Text(
                        text = playlist.value.playlist.description,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                    )
                }
                Separator()
            }

            items(playlist.value.playlist.tracks) { track ->
                SongElement(
                    type = TypeSongElement.ADD,
                    track = track,
                    onClick = { openModal(track) },
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Recomendaciones",
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                    )

                    IconButton(onClick = { playlistViewModel.getRecommendations() }) {
                        Icon(
                            modifier = Modifier.size(size = 30.dp),
                            painter = painterResource(id = R.drawable.ic_refresh),
                            contentDescription = stringResource(R.string.refresh_recommendations),
                            tint = Color.White,
                        )
                    }
                }
                Separator()
            }

            items(recommendations.value.tracks) { track ->
                SongElement(
                    onClick = { addToPlaylist(track) },
                    type = TypeSongElement.SEARCH,
                    track = track,
                )
            }
        }
    }

    if (isModalVisible) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text(text = stringResource(id = R.string.delete_track)) },
            text = {
                Text(
                    text = stringResource(
                        id = R.string.cuestion_delete_track,
                        activeTrack.title,
                    ),
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        removeFromPlaylist(track = activeTrack)
                    },
                    content = {
                        Text(text = stringResource(id = R.string.accept), color = Color.White)
                    },
                )
            },
            dismissButton = {
                Button(
                    onClick = {
                        isModalVisible = false
                    },
                    content = {
                        Text(text = stringResource(id = R.string.cancel), color = Color.White)
                    },
                )
            },
        )
    }
}
