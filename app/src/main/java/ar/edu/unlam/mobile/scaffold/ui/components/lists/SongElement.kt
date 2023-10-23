package ar.edu.unlam.mobile.scaffold.ui.components.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song

val exampleSong: Song = Song("Canción de ejemplo", "Artista de ejemplo", R.drawable.album_bubbles)

enum class TypeSongElement {
    SEARCH, ADDED, OTHER
}
@Composable
@Preview
fun SongElement(
    modifier: Modifier = Modifier,
    type: TypeSongElement = TypeSongElement.OTHER,
    song: Song = exampleSong,
    onClick: (song:Song) -> Unit)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.onPrimaryContainer)
            .fillMaxWidth(),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = song.coverArt),
                contentDescription = null,
                modifier = modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(60.dp),
            )
            Column(modifier = modifier.padding(end = 10.dp)) {
                Text(
                    text = song.title,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = song.artist,
                    color = Color(0XFFE1E1E1),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
        IconButton(
            onClick = { onClick(song) },
            modifier = Modifier
                .padding(end = 30.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primary)
                .size(35.dp),
        ) {
            Icon(
                painter = painterResource(id =
                if(type == TypeSongElement.ADDED) { R.drawable.baseline_more_horiz_24 }
                else if(type == TypeSongElement.SEARCH){ R.drawable.baseline_add_24 }
                else{R.drawable.baseline_add_24}
                ),
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(25.dp),
            )
        }
    }
}
