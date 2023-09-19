package ar.edu.unlam.mobile.scaffold.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.kitty.models.Playlist
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.lists.PlaylistListElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.components.texts.MyListsTitle


val playlists = listOf(
    Playlist(1, "Mi Playlist", R.drawable.ic_default_album2),
    Playlist(2, "Rock", R.drawable.ic_default_album2),
    Playlist(3, "Top Hits", R.drawable.ic_default_album1),
    Playlist(4, "Previa", R.drawable.ic_default_album2),
    Playlist(5, "Gym", R.drawable.ic_default_album1),
    Playlist(5, "Gym", R.drawable.ic_default_album2),
    Playlist(5, "Gym", R.drawable.ic_default_album1),
    Playlist(5, "Gym", R.drawable.ic_default_album2),
    Playlist(5, "Gym", R.drawable.ic_default_album1),
    Playlist(5, "Gym", R.drawable.ic_default_album2)
)

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    // se utilizará más adelante
    // val uiState: HomeUIState by viewModel.uiState.collectAsState()
    Body()

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun Body() {
    Box{
        Column(modifier = Modifier.padding(16.dp)) {
            TitlesHome("Mis listas", Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyRow{
                items(playlists) { playlist ->
                    PlaylistListElement(playlist)
                }
            }
            MyListsTitle("Tendencias")
            Spacer(modifier = Modifier.height(10.dp))
            LazyHorizontalGrid(
                GridCells.Fixed(2),
                Modifier.height(270.dp)
            ) {
                items(playlists) { playlist ->
                    PlaylistListElement(playlist)
                }
            }
        }
    }
}
