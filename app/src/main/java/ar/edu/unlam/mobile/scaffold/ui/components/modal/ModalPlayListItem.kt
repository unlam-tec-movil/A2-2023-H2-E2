package ar.edu.unlam.mobile.scaffold.ui.components.modal

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import coil.compose.AsyncImage
@Composable
fun ModalPlayListItem(
    playlist: Playlist = Playlist(1, "Mi Playlist Ejemplo", "https://picsum.photos/201", listOf()),
    trackId: String,
    trackTitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    fun addToPlaylis() {
        // TODO: Agregar a una playlist
        val text = "$trackTitle agregada a ${playlist.title}"
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        onClick()
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            // .clip(shape = RoundedCornerShape(5.dp))
            .background(MaterialTheme.colorScheme.onPrimaryContainer)
            .fillMaxWidth()
            .then(modifier.clickable { addToPlaylis() }),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = playlist.image,
                contentDescription = "Playlist image",
                modifier = modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(40.dp),
            )
            Column(modifier = modifier.padding(end = 10.dp)) {
                Text(
                    text = playlist.title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = playlist.tracks.size.toString() + " canciones",
                    fontWeight = FontWeight.Medium,
                    color = Color(0XFFE1E1E1),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}
