package ar.edu.unlam.mobile.scaffold.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.kitty.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.lists.PlaylistListElement
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SearchElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.components.texts.MyListsTitle

val exampleSongs =
    listOf<Song>(
        Song("Revolution Radio", "Green Day", R.drawable.album_bubbles),
        Song("Hoy Estoy Raro", "El Cuarteto De Nos", R.drawable.album_bubbles),
        Song("Paradise", "Coldplay", R.drawable.album_bubbles),
        Song("Paper Wings", "Rise Against", R.drawable.album_bubbles),
        Song("By the Way", "Red Hot Chili Peppers", R.drawable.album_bubbles),
        Song("Toxicity", "System Of A Down", R.drawable.album_bubbles),
        Song("Radioactive", "Imagine Dragons", R.drawable.album_bubbles),
        Song("Numb", "Linkin Park", R.drawable.album_bubbles),
        Song("The Hell Song", "Sum 41", R.drawable.album_bubbles),
        Song("Misery Business", "Paramore", R.drawable.album_bubbles),
    )

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun Body() {
    Box {
        Column(modifier = Modifier.padding(16.dp)) {
            MyListsTitle("Explorar")
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                items(exampleSongs) { song ->
                    SearchElement(song)
                }
            }
        }
    }
}