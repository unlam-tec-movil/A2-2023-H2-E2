package ar.edu.unlam.mobile.scaffold.ui.components.lists

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.modal.ModalAddToList
import coil.compose.AsyncImage

enum class TypeSongElement {
    SEARCH, ADDED, OTHER
}

@Composable
fun SongElement(
    modifier: Modifier = Modifier,
    type: TypeSongElement = TypeSongElement.OTHER,
    track: Track,
    // playlists: List<Playlist>,
    onClick: (track: Track) -> Unit,
) {
    var isModalVisible by remember { mutableStateOf(false) }

    fun onPressButton() {
        if (type == TypeSongElement.SEARCH) {
            isModalVisible = true
        } else if (type == TypeSongElement.ADDED) {
            onClick(track)
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            // .clip(shape = RoundedCornerShape(5.dp))
            .background(MaterialTheme.colorScheme.onPrimaryContainer)
            .fillMaxWidth(),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = track.image,
                contentDescription = "Album cover",
                modifier = modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(60.dp),
            )
            Column(modifier = modifier.padding(end = 10.dp)) {
                Text(
                    modifier = Modifier.size(width = 200.dp, height = 20.dp),
                    text = track.title,
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                Text(
                    modifier = Modifier.size(width = 200.dp, height = 20.dp),
                    text = track.artist,
                    color = Color(0XFFE1E1E1),
                    style = MaterialTheme.typography.labelMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }
        IconButton(
            onClick = { onPressButton() },
            modifier = Modifier
                .padding(end = 30.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primary)
                .size(35.dp),
        ) {
            Icon(
                painter = painterResource(
                    id =
                    if (type == TypeSongElement.ADDED) {
                        R.drawable.baseline_more_horiz_24
                    } else if (type == TypeSongElement.SEARCH) {
                        R.drawable.baseline_add_24
                    } else {
                        R.drawable.baseline_add_24
                    },
                ),
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(25.dp),
            )
        }
    }

    if (isModalVisible && type == TypeSongElement.SEARCH) {
        ModalAddToList(
            track = track, // playlists = playlists,
            onClose = { isModalVisible = false },
        )
    }
}
