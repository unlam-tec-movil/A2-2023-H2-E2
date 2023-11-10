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
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.components.texts.Title
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.TrackUiState

val exampleSongs =
    listOf(
        Song(
            "Revolution Radio",
            "Green Day",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "Hoy Estoy Raro",
            "El Cuarteto De Nos",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "Paradise",
            "Coldplay",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg"
        ),
        Song(
            "Paper Wings",
            "Rise Against",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "By the Way",
            "Red Hot Chili Peppers",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "Toxicity",
            "System Of A Down",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "Radioactive",
            "Imagine Dragons",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "Numb",
            "Linkin Park",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "The Hell Song",
            "Sum 41",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
        Song(
            "Misery Business",
            "Paramore",
            "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg",
        ),
    )

@Preview
@Composable
fun Search(homeViewModel: HomeViewModel = hiltViewModel()) {
    val trackUiState: TrackUiState by homeViewModel.trackUiState.collectAsState()

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
                        song = Song(
                            artist = track.artist,
                            coverArt = track.image,
                            title = track.title
                        ), onClick = {})
                }
            }
        }
    }
}
