package ar.edu.unlam.mobile.scaffold.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.lists.ListDialog
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SongElement
import ar.edu.unlam.mobile.scaffold.ui.components.lists.TypeSongElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.components.texts.Title

val exampleSongs =
    listOf(
        Song("Revolution Radio", "Green Day", R.drawable.greenday),
        Song("Hoy Estoy Raro", "El Cuarteto De Nos", R.drawable.nos),
        Song("Paradise", "Coldplay", R.drawable.coldplay),
        Song("Paper Wings", "Rise Against", R.drawable.riseagainst),
        Song("By the Way", "Red Hot Chili Peppers", R.drawable.rhcp),
        Song("Toxicity", "System Of A Down", R.drawable.soad),
        Song("Radioactive", "Imagine Dragons", R.drawable.imaginedragons),
        Song("Numb", "Linkin Park", R.drawable.linkinpark),
        Song("The Hell Song", "Sum 41", R.drawable.sum41),
        Song("Misery Business", "Paramore", R.drawable.paramore),
        Song("By the Way", "Red Hot Chili Peppers", R.drawable.rhcp),
        Song("Toxicity", "System Of A Down", R.drawable.soad),
        Song("Radioactive", "Imagine Dragons", R.drawable.imaginedragons),
        Song("Numb", "Linkin Park", R.drawable.linkinpark),
        Song("The Hell Song", "Sum 41", R.drawable.sum41),
        Song("Hoy Estoy Raro", "El Cuarteto De Nos", R.drawable.nos),
        Song("Paradise", "Coldplay", R.drawable.coldplay),
        Song("Paper Wings", "Rise Against", R.drawable.riseagainst),
        Song("By the Way", "Red Hot Chili Peppers", R.drawable.rhcp),
        Song("Toxicity", "System Of A Down", R.drawable.soad),
    )
val examplePlaylists = listOf(
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
@Preview
@Composable
fun Search() {

    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp
    val screenWidthDp = configuration.screenWidthDp
    var isModalVisible by remember { mutableStateOf(false) }
    var activeSong by remember { mutableStateOf<Song>(exampleSongs[0]) }

    fun openModal(song:Song) {
        isModalVisible = true
    }
    fun addToPlaylist(playlistId: Long){
        //Agregar cancion a la playlist
        isModalVisible = false
    }

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
                items(exampleSongs) { song ->
                    SongElement(type = TypeSongElement.SEARCH,song = song){
                        openModal(song)
                    }
                }
            }
        }
    }
    if(isModalVisible) {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ){
                Column (
                    modifier = Modifier
                        .background((MaterialTheme.colorScheme.onPrimaryContainer))
                        .padding(16.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .height(((screenHeightDp * 0.8)).dp)
                        .width((screenWidthDp * 0.8).dp)
                )
                {
                    Text(
                        text = "Agregar a una lista",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.
                        padding(vertical = 12.dp)
                    )
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                        items(examplePlaylists){ playlist ->
                           ListDialog(playlist = playlist, activeSong = activeSong){
                               addToPlaylist(playlistId = playlist.id)
                           }
                        }
                    }
                }
            //MySnackBar()
        }
    }


}
