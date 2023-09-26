package ar.edu.unlam.mobile.scaffold.ui.components.buttons


import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import ar.edu.unlam.mobile.scaffold.R


@Composable
fun FabScreen(onFabClick: () -> Unit = {}) {
    FloatingActionButton(onClick = { onFabClick()}) {
        Icon(painter = painterResource(id = R.drawable.ic_icon_add), contentDescription = "Crear playlist")
    }
}