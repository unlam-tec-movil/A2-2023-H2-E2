package ar.edu.unlam.mobile.scaffold.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist
import ar.edu.unlam.mobile.scaffold.ui.components.texts.Title
import ar.edu.unlam.mobile.scaffold.ui.theme.Blue73
import ar.edu.unlam.mobile.scaffold.ui.theme.DisableButtonColorPlaylist
import ar.edu.unlam.mobile.scaffold.ui.viewmodels.PlaylistViewModel
import coil.compose.AsyncImage

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true, backgroundColor = 0xFF111124L, showSystemUi = true)
@Composable
fun CreatePlaylist(playlistViewModel: PlaylistViewModel = hiltViewModel()) {
    val srcImageDefault =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbvl7F2ldQV89pon03gwyu0LL-mdrSXf4MaQ&usqp=CAU"
    val context = LocalContext.current
    Box(contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Title(
                modifier = Modifier.padding(top = 18.dp),
                title = stringResource(id = R.string.create_list_title),
            )

            Spacer(modifier = Modifier.height(45.dp))

            AsyncImage(
                model = srcImageDefault,
                contentDescription = "Imagen de muestra",
                modifier = Modifier
                    .height(270.dp)
                    .width(370.dp),
                contentScale = ContentScale.FillBounds,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.End,
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_icon_add),
                        contentDescription = "Cargar imagen",
                        tint = Color.White,
                    )
                }
            }

            Spacer(modifier = Modifier.height(45.dp))

            val localManager = LocalSoftwareKeyboardController.current
            var textNameInput by remember { mutableStateOf("") }
            val textFieldColor = Color.White
            val containerColor = Blue73
            TextField(
                value = textNameInput,
                onValueChange = { textNameInput = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = containerColor,
                    focusedContainerColor = containerColor,
                    focusedTextColor = textFieldColor,
                    unfocusedTextColor = textFieldColor,
                    disabledLabelColor = textFieldColor,
                    focusedLabelColor = textFieldColor,
                ),
                label = { Text(text = "Nombre", color = textFieldColor) },
                singleLine = true,
                maxLines = 1,
                keyboardActions = KeyboardActions(
                    onDone = { localManager?.hide() },
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(35.dp))
            var textDescriptionInput by remember { mutableStateOf("") }

            TextField(
                value = textDescriptionInput,
                onValueChange = { textDescriptionInput = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = containerColor,
                    focusedContainerColor = containerColor,
                    focusedTextColor = textFieldColor,
                    unfocusedTextColor = textFieldColor,
                    disabledLabelColor = textFieldColor,
                    focusedLabelColor = textFieldColor,

                ),
                singleLine = true,
                maxLines = 1,
                keyboardActions = KeyboardActions(
                    onDone = { localManager?.hide() },
                ),
                label = { Text(text = "Descripción", color = textFieldColor) },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(35.dp))

            var buttonEnabled by remember { mutableStateOf(false) }

            buttonEnabled = textNameInput != "" && textDescriptionInput != ""

            Button(
                enabled = buttonEnabled,
                onClick = {
                    playlistViewModel.addPlaylist(
                        Playlist(
                            title = textNameInput,
                            description = textDescriptionInput,
                            image = srcImageDefault,
                        ),
                    )
                    Toast.makeText(context, R.string.playlist_created, Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = textFieldColor,
                    disabledContainerColor = DisableButtonColorPlaylist,
                ),
            ) {
                Text(text = "Guardar", fontSize = 27.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "Guardar lista",
                    modifier = Modifier.size(33.dp),
                )
            }
        }
    }
}
