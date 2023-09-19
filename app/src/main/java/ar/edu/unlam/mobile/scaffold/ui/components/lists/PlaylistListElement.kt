package ar.edu.unlam.mobile.scaffold.ui.components.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import ar.edu.unlam.mobile.scaffold.domain.kitty.models.Playlist

@Composable
fun PlaylistListElement(playlist: Playlist, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(end = 10.dp, bottom = 10.dp).wrapContentHeight()) {
        Image(
            painter = painterResource(id = playlist.image),
            contentDescription = null,
            modifier = modifier.clip(RoundedCornerShape(5.dp))
        )
        Text(text = playlist.title, style = MaterialTheme.typography.labelLarge)
    }
}