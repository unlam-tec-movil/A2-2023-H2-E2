package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.buttons.FabScreen
import ar.edu.unlam.mobile.scaffold.ui.components.lists.PlaylistListElement
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongListElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.TrendsUIState

@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home.name) {
        composable(Routes.Home.name) {
            HomeScreen(
                navController,
                onSearchClick = {
                    navController.navigate(Routes.CreatePlaylist.name)
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
        composable(Routes.PlaylistScreen.name + "/{item}") {
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
    playlistViewModel: PlaylistViewModel = hiltViewModel(),
    modifier: Modifier,
) {
    val trendsUiState by viewModel.appUiState.trendsState.collectAsState()
    val playlistUIState by playlistViewModel.allPlaylistUiState.collectAsState()

    if(trendsUiState.loading || playlistUIState.isLoading){
        CircularProgressIndicator(strokeCap = StrokeCap.Butt)
    } else{
        Scaffold(floatingActionButton = { FabScreen(onFabClick) }) { paddingValues ->
            Body(
                navController = navController,
                playlists = playlistUIState.playlists,
                onSearchClick = onSearchClick,
                modifier = Modifier.padding(paddingValues),
                trendsUiState = trendsUiState,
            )
        }
    }
}
@Composable
fun Body(
    navController: NavController,
    playlists: List<Playlist>,
    trendsUiState: TrendsUIState,
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
) {
    Box {
        Column(modifier = Modifier.padding(14.dp)) {
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
            if (playlists.isNotEmpty()) {
                Spacer(modifier = Modifier.height(30.dp))
                LazyRow {
                    items(playlists) { playlist ->
                        PlaylistListElement(
                            playlist.id.toString(),
                            title = playlist.title,
                            playlist.image,
                            navController = navController,
                        )
                    }
                }
            } else {
                Text(
                    text = "Todavia no tenés playlists creadas",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                )
                IconButton(
                    onClick = { navController.navigate(Routes.CreatePlaylist.name) },
                    modifier = Modifier
                        .padding(end = 30.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(MaterialTheme.colorScheme.primary)
                        .size(46.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_icon_add),
                        contentDescription = "Crear playlist",
                        tint = Color.White,
                        modifier = modifier.size(28.dp),
                    )
                }
            }

            Text(
                text = "Tendencias",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            )
            if (trendsUiState.loading) {
                CircularProgressIndicator()
            } else {
                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                ) {
                    items(trendsUiState.tracks) { track ->
                        SongListElement(track.spotifyId, track.title, track.artist, track.image)
                    }
                }
            }
        }
    }
}
