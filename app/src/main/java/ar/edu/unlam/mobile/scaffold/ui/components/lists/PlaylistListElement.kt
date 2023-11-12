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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.unlam.mobile.scaffold.ui.screens.Routes
import coil.compose.AsyncImage

@Composable
fun PlaylistListElement(
    playlistId: String,
    title: String,
    image: String,
    mostrarTitulo: Boolean = true,
    fullWidth: Boolean = false,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    fun onPlaylistClick() {
        navController.navigate(
            route = Routes.PlaylistScreen.name + "/$playlistId",
        )
    }

    Column(
        modifier = modifier
            .padding(end = 10.dp, bottom = 10.dp)
            .wrapContentHeight()
            .then(modifier.clickable { onPlaylistClick() }),
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .clip(RoundedCornerShape(5.dp))
                .width(if (fullWidth) ((screenWidthDp / 2) - 16.dp) else 150.dp)
                .height(if (fullWidth) ((screenWidthDp / 2) - 16.dp) else 150.dp)
                .align(Alignment.CenterHorizontally),
        )
        if (mostrarTitulo) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
            )
        }
    }
}
