package ar.edu.unlam.mobile.scaffold.ui.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile.scaffold.ui.theme.MyApplicationTheme

@Composable
fun Title(modifier: Modifier = Modifier, title: String = "Spotilist") {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Bold,
        color = Color.White,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun TitlePreview() {
    MyApplicationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Title()
        }
    }
}
