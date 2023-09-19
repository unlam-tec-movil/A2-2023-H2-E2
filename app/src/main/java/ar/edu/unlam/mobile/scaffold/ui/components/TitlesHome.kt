package ar.edu.unlam.mobile.scaffold.ui.components


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffold.ui.components.texts.MyListsTitle
import ar.edu.unlam.mobile.scaffold.ui.components.texts.ViewAllsOption

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showBackground = true, showSystemUi = true, backgroundColor = 4343453L)
@Composable
fun TitlesHome(title: String = "Mis listas", modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        MyListsTitle(title)
        Spacer(modifier = Modifier.width(50.dp))
        ViewAllsOption(modifier.padding(top = 16.5.dp))
    }
}