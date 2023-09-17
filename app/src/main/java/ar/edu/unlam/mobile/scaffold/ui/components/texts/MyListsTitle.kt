package ar.edu.unlam.mobile.scaffold.ui.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile.scaffold.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyListsTitle(modifier: Modifier = Modifier) {
    Text(
        stringResource(id = R.string.my_list_title),
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}