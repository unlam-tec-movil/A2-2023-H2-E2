package ar.edu.unlam.mobile.scaffold.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import ar.edu.unlam.mobile.scaffold.ui.components.lists.SearchElement
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar
import ar.edu.unlam.mobile.scaffold.ui.components.texts.MyListsTitle

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
    )

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun Search() {
    Box {
        Column(modifier = Modifier.padding(16.dp)) {
            MyListsTitle(title = "Explorar")
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = RoundedCornerShape(8.dp))

            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                items(exampleSongs) { song ->
                    SearchElement(song = song)
                }
            }
        }
    }
}