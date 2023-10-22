package ar.edu.unlam.mobile.scaffold.ui.components.search

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ar.edu.unlam.mobile.scaffold.R
import ar.edu.unlam.mobile.scaffold.ui.theme.Gray93

@Preview(showBackground = true, showSystemUi = true)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var textFieldState by remember { mutableStateOf("") }
    val backgroundColorTextField = Gray93
    val elementsColorValue = Color.White

    val localManager = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier,
        value = textFieldState,
        onValueChange = { textFieldState = it },
        shape = OutlinedTextFieldDefaults.shape,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon",
            )
        },
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions(
            onDone = { localManager?.hide() },
        ),
        placeholder = { Text(stringResource(id = R.string.placeholder_search)) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = backgroundColorTextField,
            unfocusedContainerColor = backgroundColorTextField,
            disabledContainerColor = backgroundColorTextField,
            focusedLeadingIconColor = elementsColorValue,
            unfocusedLeadingIconColor = elementsColorValue,
            focusedTextColor = elementsColorValue,
            unfocusedTextColor = elementsColorValue,
            focusedPlaceholderColor = elementsColorValue,
            unfocusedPlaceholderColor = elementsColorValue,
        ),
    )
}
