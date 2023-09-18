package ar.edu.unlam.mobile.scaffold.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.components.TitlesHome
import ar.edu.unlam.mobile.scaffold.ui.components.search.SearchBar

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun HomeScreen() {
    Box() {
        Column(modifier = Modifier.padding(16.dp)) {
            TitlesHome(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
        }
    }
}
