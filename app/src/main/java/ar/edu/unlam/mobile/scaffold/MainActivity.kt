package ar.edu.unlam.mobile.scaffold

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import ar.edu.unlam.mobile.scaffold.ui.screens.NavigationView
import ar.edu.unlam.mobile.scaffold.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token_api")

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    /*val viewModel: HomeViewModel by viewModels()

                    val authorizationToken = viewModel.getAuthorization()
                    lifecycleScope.launch(Dispatchers.IO) {
                        dataStore.edit { preferences ->
                            preferences[stringPreferencesKey("token_api")] = authorizationToken
                        }
                    }*/
                    NavigationView()
                }
            }
        }
    }
}

/*@Composable
fun MainScreen() {
    // Controller es el elemento que nos permite navegar entre pantallas. Tiene las acciones
    // para navegar como navigate y también la información de en dónde se "encuentra" el usuario
    // a través del back stack
    val controller = rememberNavController()
    Scaffold(
        /*bottomBar = { BottomBar(controller = controller) },*/
        floatingActionButton = {
            IconButton(onClick = { controller.navigate("home") }) {
                Icon(Icons.Filled.Home, contentDescription = "Home")
            }
        },
    ) { paddingValue ->
        NavHost(navController = controller, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    onSearchClick = { /*TODO: cambiar por la implementación*/ },
                    onFabClick = { /*TODO: cambiar por la implementación*/ },
                    modifier = Modifier.padding(paddingValue),
                )
            }
            composable(
                route = "segundo/{id}",
                arguments = listOf(navArgument("id") { type = NavType.IntType }),
            ) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getInt("id") ?: 1
                SecondaryScreen(controller = controller, id = id)
            }
        }
    }
}
*/
