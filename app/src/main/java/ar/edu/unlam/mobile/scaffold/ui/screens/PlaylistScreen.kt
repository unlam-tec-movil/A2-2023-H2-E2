package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SearchElement
import kotlinx.coroutines.flow.collectLatest

val fakePlaylist2 = Playlist(9, "Finde", R.drawable.album_beach)

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true, backgroundColor = 0xFF111124L, showSystemUi = true)
@Composable
fun PlaylistScreen (){

    var imagenPlegada = remember { mutableStateOf<Boolean>(false) };
    val listState = rememberLazyListState()
    var visibleItems by remember { mutableStateOf<List<Song>>((exampleSongs)) }

    Box(contentAlignment = Alignment.TopCenter) {

        LaunchedEffect(listState.isScrollInProgress) {
            if (listState.isScrollInProgress) {
                Log.i("Tag", "El scroll está en progreso")
                imagenPlegada.value = true
            }else{
                imagenPlegada.value = false
            }
        }

        LazyColumn(
            state = listState,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
           item{
               Image(
                   painter = painterResource(fakePlaylist2.image),
                   contentDescription = "Imagen de muestra",
                   modifier = Modifier
                       .height(if(imagenPlegada.value){ 120.dp} else {270.dp})
                       .width(if(imagenPlegada.value){ 120.dp} else {270.dp})
                       .padding(vertical = 20.dp, horizontal = 12.dp),
                   contentScale = ContentScale.FillBounds,

                   )
           }
            items(exampleSongs) { song ->
                SearchElement(song = song){

                }
            }
        }

    }
}