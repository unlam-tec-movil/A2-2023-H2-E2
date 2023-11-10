package ar.edu.unlam.mobile.scaffold.ui.components.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.theme.Gray93
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.HomeViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    var queryState by remember { mutableStateOf("") }
    var searchBarIsActive by remember { mutableStateOf(false) }


    val elementsColorValue = Color.White

    val localManager = LocalSoftwareKeyboardController.current


    SearchBar(
        query = queryState,
        onQueryChange = { queryState = it },
        onSearch = {
            localManager?.hide()
            searchBarIsActive = false
        },
        active = searchBarIsActive,
        placeholder = { Text(text = "Busca canciones o artistas") },
        onActiveChange = { searchBarIsActive = it },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Busqueda",
                tint = elementsColorValue
            )
        },
        modifier = Modifier.padding(start = 5.dp, end = 10.dp),
        colors = SearchBarDefaults.colors(
            containerColor = Gray93,
            dividerColor = Color.White,
            inputFieldColors = TextFieldDefaults
                .colors(
                    focusedTextColor = elementsColorValue,
                    unfocusedTextColor = elementsColorValue,
                    unfocusedPlaceholderColor = elementsColorValue,
                    focusedPlaceholderColor = elementsColorValue,
                    disabledTrailingIconColor = elementsColorValue,
                    focusedTrailingIconColor = elementsColorValue
                )
        )

    ) {
        if (queryState.isNotEmpty()) {
            homeViewModel.getTrackBySearchBar(query = queryState)
            homeViewModel.trackUiState.value.tracks.forEach { track ->
                val song = Song(
                    artist = track.artist,
                    title = track.title,
                    coverArt = track.image,
                    srcSpotify = track.srcSpotify
                )

                SongElement(
                    onClick = {},
                    song = song
                )
            }
        }
    }
}
