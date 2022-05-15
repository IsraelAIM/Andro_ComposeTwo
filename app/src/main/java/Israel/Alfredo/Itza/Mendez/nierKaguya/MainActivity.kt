package Israel.Alfredo.Itza.Mendez.nierKaguya

//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
import Israel.Alfredo.Itza.Mendez.nierKaguya.nier.MainAppBar
import Israel.Alfredo.Itza.Mendez.nierKaguya.nier.MediaXList
import Israel.Alfredo.Itza.Mendez.nierKaguya.nier.MiNierApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
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
                Scaffold(
                    topBar = { MainAppBar() }
                ) { padding ->
                    MediaXList(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}