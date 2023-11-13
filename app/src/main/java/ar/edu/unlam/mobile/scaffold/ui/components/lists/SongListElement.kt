package ar.edu.unlam.mobile.scaffold.ui.components.lists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.modal.ModalAddToList
import coil.compose.AsyncImage

@Composable
fun SongListElement(
    track: Track,
    playlists: List<Playlist>,
    mostrarTitulo: Boolean = true,
    fullWidth: Boolean = true,
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    val screenWidthDp = configuration.screenWidthDp
    var isModalVisible by remember { mutableStateOf(false) }

    fun onCloseModal() {
        isModalVisible = false
    }

    Column(
        modifier = modifier
            .padding(end = 10.dp, bottom = 10.dp)
            .wrapContentHeight()
            .then(modifier.clickable { isModalVisible = true }),
    ) {
        AsyncImage(
            model = track.image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .clip(RoundedCornerShape(5.dp))
                .width(if (fullWidth) ((screenWidthDp.dp / 2) - 16.dp) else 150.dp)
                .height(if (fullWidth) ((screenWidthDp.dp / 2) - 16.dp) else 150.dp)
                .align(Alignment.CenterHorizontally),
        )
        if (mostrarTitulo) {
            Text(
                text = track.title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
            )
        }
    }

    if (isModalVisible) {
        ModalAddToList(
            track = track,
            playlists = playlists,
            onClose = { onCloseModal() },
        )
    }
}
