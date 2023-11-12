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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.buttons.FabScreen
import ar.edu.unlam.mobile.scaffold.ui.components.lists.PlaylistListElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel

val fakePlaylist = listOf(
    Playlist(1, "Mi Playlist", "https://picsum.photos/200", tracks = listOf()),
    Playlist(2, "Rock", "https://picsum.photos/201", tracks = listOf()),
    Playlist(3, "Top Hits", "https://picsum.photos/202", tracks = listOf()),
    Playlist(4, "Previa", "https://picsum.photos/203", tracks = listOf()),
)

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
    }
}

@Composable
fun HomeScreen(
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
            playlist = fakePlaylist,
            trendingTracks = trendsUiState.tracks,
            onSearchClick = onSearchClick,
            modifier = Modifier.padding(paddingValues),
        )
//        }
    }
}

@Preview
@Composable
private fun BodyPreview() {
    Body(
        playlist = fakePlaylist,
        trendingTracks = listOf(Track("", "", "", ""), Track("", "", "", "")),
    )
}

@Composable
private fun Body(
    playlist: List<Playlist>,
    trendingTracks: List<Track>,
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
) {
    Box {
        Column(modifier = Modifier.padding(16.dp)) {
            TitlesHome(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = "Mis listas",
                onSearchClick = onSearchClick,
            )
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyRow {
                items(playlist) { playlist ->
                    PlaylistListElement(playlist.title, playlist.image)
                }
            }
            Text(
                text = "Tendencias",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            )
            LazyHorizontalGrid(
                GridCells.Fixed(2),
                Modifier.height(270.dp),
            ) {
                items(trendingTracks) { track ->
                    PlaylistListElement(track.title, track.image)
                }
            }
        }
    }
}
