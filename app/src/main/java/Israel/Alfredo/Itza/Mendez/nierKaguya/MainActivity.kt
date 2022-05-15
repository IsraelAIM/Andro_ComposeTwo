package Israel.Alfredo.Itza.Mendez.nierKaguya

//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
import Israel.Alfredo.Itza.Mendez.nierKaguya.nier.MiNierApp
import Israel.Alfredo.Itza.Mendez.nierKaguya.screen.main.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
                MainScreen()
            }
        }
    }


}