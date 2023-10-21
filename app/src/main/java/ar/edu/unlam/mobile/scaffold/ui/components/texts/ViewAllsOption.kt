package ar.edu.unlam.mobile.scaffold.ui.components.texts

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffold.R

@Preview(showSystemUi = true)
@Composable
fun ViewAllsOption(onSearchClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Text(
        stringResource(id = R.string.view_all_title),
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.onPrimary,
        fontWeight = FontWeight.Bold,
        modifier = modifier.clickable(onClick = onSearchClick)
    )
}
