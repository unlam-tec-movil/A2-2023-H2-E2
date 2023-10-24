package ar.edu.unlam.mobile.scaffold.ui.components

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
import ar.edu.unlam.mobile.scaffold.ui.components.texts.Title
import ar.edu.unlam.mobile.scaffold.ui.components.texts.ViewAllsOption

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 4343453L)
@Composable
fun TitlesHome(
    modifier: Modifier = Modifier,
    title: String = "Mis listas",
    onSearchClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Title(title = title)
        Spacer(modifier = Modifier.width(50.dp))
        ViewAllsOption(onSearchClick, modifier.padding(top = 16.5.dp))
    }
}
