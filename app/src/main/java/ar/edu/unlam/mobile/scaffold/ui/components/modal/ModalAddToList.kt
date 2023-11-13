package ar.edu.unlam.mobile.scaffold.ui.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.others.Separator
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import coil.compose.AsyncImage

@Composable
fun ModalAddToList(
    track: Track,
    // playlists: List<Playlist>,
    onClose: () -> Unit = {},
    modifier: Modifier = Modifier,
    playlistViewModel: PlaylistViewModel = hiltViewModel(),
) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    val screenWidthDp = configuration.screenWidthDp

    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        ),
    ) {
        Column(
            modifier = Modifier
                .background((MaterialTheme.colorScheme.onPrimaryContainer))
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .height(((screenHeightDp * 0.75)).dp)
                .width((screenWidthDp * 0.7).dp),
        ) {
            AsyncImage(
                model = track.image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width((screenWidthDp * 0.6).dp - 10.dp)
                    .height((screenWidthDp * 0.6).dp - 20.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Text(
                text = track.title,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 10.dp),
            )
            Text(
                text = track.artist,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 8.dp),
            )
            Separator()
            Text(
                text = "Agregar a una playlist",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 8.dp),
            )
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(playlistViewModel.allPlaylistUiState.value.playlists) { playlist ->
                    ModalPlayListItem(
                        playlist = playlist,
                        trackId = track.spotifyId,
                        trackTitle = track.title,
                        onClick = { onClose },
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                    ) {
                        Button(
                            onClick = { onClose() },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = "Cancelar",
                                color = Color.White,
                            )
                        }
                    }
                }
            }
        }
    }
}
