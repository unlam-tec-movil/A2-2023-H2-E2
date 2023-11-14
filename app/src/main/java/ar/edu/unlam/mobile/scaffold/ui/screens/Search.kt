package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.components.texts.Title
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistUIState
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.TrackUIState

@Preview
@Composable
fun Search(homeViewModel: HomeViewModel = hiltViewModel()) {
    val trackUiState: TrackUIState by homeViewModel.appUiState.trackState.collectAsState()
    val playlistUIState: PlaylistUIState by homeViewModel.appUiState.playlistState.collectAsState()

    Box {
        Column(modifier = Modifier.padding(16.dp)) {
            Title(title = "Explorar")
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = RoundedCornerShape(8.dp)),
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                items(trackUiState.tracks) { track ->
                    SongElement(
                        track = track,
                        // playlists = playlistUIState.playlists,
                        onClick = {},
                    )
                }
            }
        }
    }
}
