package ar.edu.unlam.mobile.scaffold.ui.components.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song

var listaEjemlpo = Playlist(1, "Mi Playlist", "asd", listOf())

@Composable
fun ListDialog(
    modifier: Modifier = Modifier,
    playlist: Playlist = listaEjemlpo,
    activeSong: Song,
    onClick: (playlistId: Long) -> Unit,
) {
    Box(
        modifier = Modifier.then(Modifier.clickable { onClick(playlist.id) }),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Image(
                // TODO: cambiar el painterResource por el verdadero
                painter = painterResource(id = R.drawable.album_beach),
                contentDescription = null,
                modifier = modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(50.dp),
            )
            Column(modifier = modifier.padding(horizontal = 10.dp)) {
                Text(
                    text = playlist.title,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = "25 canciones",
                    color = Color(0xFFE1E1E1),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}
