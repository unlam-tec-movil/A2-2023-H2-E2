package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.buttons.FabScreen
import ar.edu.unlam.mobile.scaffold.ui.components.lists.PlaylistListElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel

val fakePlaylist = listOf(
    Playlist(1, "Mi Playlist", "https://picsum.photos/200", songs = listOf()),
    Playlist(2, "Rock", "https://picsum.photos/201", songs = listOf()),
    Playlist(3, "Top Hits", "https://picsum.photos/202", songs = listOf()),
    Playlist(4, "Previa", "https://picsum.photos/203", songs = listOf()),
)
val fakePlaylistSka = listOf(
    Track("rwbewb", "Mi cancion", "Nurbking", "https://picsum.photos/201", "https://picsum.photos/201")
)

@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.name) {
        composable(Routes.Home.name) {
            HomeScreen(
                navController,
                onSearchClick = {
                    navController.navigate(Routes.Search.name)
                },
                onFabClick = {
                    navController.navigate(Routes.CreatePlaylist.name)
                },
                modifier = Modifier,
            )
        }
        composable(Routes.Search.name) {
            Search()
        }

        composable(Routes.CreatePlaylist.name) {
            CreatePlaylist()
        }
        composable( Routes.PlaylistScreen.name + "/{item}") {
            val item = it.arguments?.getString("item")
            PlaylistScreen(item = item)
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavController,
    onSearchClick: () -> Unit,
    onFabClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier,
) {
    val trendsUiState by viewModel.trendsUiState.collectAsState()
    Scaffold(floatingActionButton = { FabScreen(onFabClick) }) { paddingValues ->
//        if (trackUiState.loading) {
//            CircularProgressIndicator()
//        } else {
        Body(
            navController = navController,
            playlist = fakePlaylistSka,
            trendingTracks = trendsUiState.tracks,
            onSearchClick = onSearchClick,
            modifier = Modifier.padding(paddingValues),
        )
//        }
    }
}
/*
@Preview
@Composable
private fun BodyPreview() {
    Body(
        playlist = fakePlaylist,
        trendingTracks = listOf(Track("", "", "", ""), Track("", "", "", "")),
    )
}
*/
@Composable
private fun Body(
    navController: NavController,
    playlist: List<Track>,
    trendingTracks: List<Track>,
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
) {
    Box {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            )
            TitlesHome(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = "Mis listas",
                onSearchClick = onSearchClick,
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyRow {
                items(playlist) { playlist ->
                    //PlaylistListElement(playlist.id, playlist.title, playlist.image)
                    PlaylistListElement(playlist.spotifyId, playlist.title, playlist.image, navController = navController)
                }
            }
            Text(
                text = "Tendencias",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            )
            LazyVerticalGrid(
                GridCells.Fixed(2),
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                // PlaylistListElement("8282qcw", true, true, navController = navController

                items(trendingTracks) { track ->
                    PlaylistListElement(track.spotifyId, track.title, track.image,
                        true, true, navController = navController)
                }
            }
        }
    }
}
