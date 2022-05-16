package Israel.Alfredo.Itza.Mendez.nierKaguya

//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
import Israel.Alfredo.Itza.Mendez.nierKaguya.nier.MiNierApp
import Israel.Alfredo.Itza.Mendez.nierKaguya.screen.detail.DetailScreen
import Israel.Alfredo.Itza.Mendez.nierKaguya.screen.main.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi


class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //El setContent es esencial
        setContent {
            MiNierApp() {
                //Aqui ejecuta la funcion, dandole un parametro. Este será lanzado a la app.
                //Greeting("Android")
                //BotonTexto()
                //MediaItem()
                //MediaList()
                //MediaRowList()
                //MediaVGList()
                /* val (value, onValueChange) = rememberSaveable { mutableStateOf("") }
                 EstadoSample(
                     value = value,
                     onValueChange = onValueChange)*/
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable(
                        route = "detail/{mediaId}",
                        arguments = listOf(navArgument("mediaId") {
                            type =
                                NavType.IntType
                        })
                    ) { backStackEntry->
                        val id= backStackEntry.arguments?.getInt("mediaId")
                        requireNotNull(id,{"No puede ser nulo porque el detalle siempre necesita un id"})
                        DetailScreen(id)
                    }
                }

            }
        }
    }


}