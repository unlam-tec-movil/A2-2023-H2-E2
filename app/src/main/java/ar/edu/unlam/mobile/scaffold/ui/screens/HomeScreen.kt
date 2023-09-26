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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.buttons.FabScreen
import ar.edu.unlam.mobile.scaffold.ui.components.lists.PlaylistListElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel


val playlists = listOf(
    Playlist(1, "Mi Playlist", R.drawable.ic_default_album1),
    Playlist(2, "Rock", R.drawable.album_guitar),
    Playlist(3, "Top Hits", R.drawable.album_disc),
    Playlist(4, "Previa", R.drawable.album_drinks),
    Playlist(5, "Gym", R.drawable.album_gym),
    Playlist(6, "Mis Favoritos", R.drawable.ic_default_album2),
    Playlist(7, "Trap", R.drawable.album_party),
    Playlist(8, "Para Programar", R.drawable.album_computer),
    Playlist(9, "Finde", R.drawable.album_beach),
    Playlist(10, "ASMR", R.drawable.album_bubbles)
)

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.name) {
        composable(Routes.Home.name) {
            HomeScreen(
                onSearchClick = {
                    navController.navigate(Routes.Search.name)
                },

                onFabClick = {
                    navController.navigate(Routes.CreatePlaylist.name)
                }

            )
        }
        composable(Routes.Search.name) {
            Search()
        }

        composable(Routes.CreatePlaylist.name){
            CreatePlaylist()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun HomeScreen(
    onSearchClick: () -> Unit, onFabClick: () -> Unit, viewModel: HomeViewModel = hiltViewModel()
) {
//    se utilizará más adelante
//    val uiState by viewModel.uiState.collectAsState()
    Scaffold(floatingActionButton = { FabScreen(onFabClick) }) { paddingValues ->

        Body(onSearchClick = onSearchClick, modifier = Modifier.padding(paddingValues))
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun Body(modifier: Modifier = Modifier, onSearchClick: () -> Unit = {}) {
    Box {
        Column(modifier = Modifier.padding(16.dp)) {
            TitlesHome(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = "Mis listas",
                onSearchClick = onSearchClick
            )
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyRow {
                items(playlists) { playlist ->
                    PlaylistListElement(playlist)
                }
            }
            Text(
                text = "Tendencias",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
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
