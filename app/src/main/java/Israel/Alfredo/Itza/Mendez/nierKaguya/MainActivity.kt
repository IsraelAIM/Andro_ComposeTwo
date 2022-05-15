package Israel.Alfredo.Itza.Mendez.nierKaguya

//import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
import Israel.Alfredo.Itza.Mendez.nierKaguya.MediaItem.Type
import Israel.Alfredo.Itza.Mendez.nierKaguya.ui.theme.NierKaguyaTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //El setContent es esencial
        setContent {
            //EL NierKaguyaTheme es esencial también
            NierKaguyaTheme {
                //Surface por el tipo
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = stringResource(id = R.string.app_name)) },
                                navigationIcon={
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = null
                                        )
                                    }
                                }
                            )
                        }
                    ) { padding ->
                        MediaXList(modifier = Modifier.padding(padding))
                    }
                }
            }
        }
    }
}

@Composable
fun Appbar() {

}

@ExperimentalFoundationApi
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaXList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(150.dp),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaVGListItem(item, Modifier.padding(2.dp))
        }
    }
}


//@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable //Recibir parametros no permite el uso de Previews
fun EstadoSample(value: String, onValueChange: (String) -> Unit) {
    // var text by remember{ mutableStateOf("")}
    //Linea que permite guardar info al rotar el movil y otra más

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(8.dp)
        )
        Button(
            onClick = { onValueChange("") },
            modifier = Modifier.fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text(text = "Clear")
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaVGList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        //cells = GridCells.Fixed(2)
        cells = GridCells.Adaptive(200.dp)
    ) {
        items(getMedia()) { item ->
            MediaVGListItem(item, Modifier.padding(2.dp))
        }
    }
}

@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaVGListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.thumb,
                    /*builder = {
                      /*  transformations(
                            (CircleCropTransformation()) //CIRCULAR
                        )
                        crossfade(true)*/
                              //transformations(BlurTransformation(LocalContext.current)) //EFECTO BLUR
                    },*/
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    Icons.Default.PlayCircleOutline, //Outlined, Filled, Rounded, Sharp, TwoTone
                    contentDescription = null,
                    modifier = Modifier.size(92.dp),
                    tint = Color.White
                )
            }

            //Icon(painter=painterResource(id=R.drawable.asdsds) EJEMPLO
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}
//FIN VERTICAL GRID

//INICIO LAZYCOLUMN
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaList() {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(getMedia()) { item ->
            MediaListItem(item)
        }
    }
}

@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.thumb,
                    /*builder = {
                      /*  transformations(
                            (CircleCropTransformation()) //CIRCULAR
                        )
                        crossfade(true)*/
                              //transformations(BlurTransformation(LocalContext.current)) //EFECTO BLUR
                    },*/
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    Icons.Default.PlayCircleOutline, //Outlined, Filled, Rounded, Sharp, TwoTone
                    contentDescription = null,
                    modifier = Modifier.size(92.dp),
                    tint = Color.White
                )
            }
            //Icon(painter=painterResource(id=R.drawable.asdsds) EJEMPLO
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}
//FIN VERTICAL

//INICIO HORIZONTAL
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaRowList() {
    LazyRow(
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(getMedia()) { item ->
            MediaRListItem(item)
        }
    }
}

@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaRListItem(item: MediaItem) {
    Column(
        modifier = Modifier.width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.thumb,
                    /*builder = {
                      /*  transformations(
                            (CircleCropTransformation()) //CIRCULAR
                        )
                        crossfade(true)*/
                              //transformations(BlurTransformation(LocalContext.current)) //EFECTO BLUR
                    },*/
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    Icons.Default.PlayCircleOutline, //Outlined, Filled, Rounded, Sharp, TwoTone
                    contentDescription = null,
                    modifier = Modifier.size(92.dp),
                    tint = Color.White
                )
            }
            //Icon(painter=painterResource(id=R.drawable.asdsds) EJEMPLO
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

//Este es la función que interviene
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun BotonTexto() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Sharon, por favor",
            modifier = Modifier
                .clickable { }
                .background(Color.Cyan)
                .border(width = 2.dp, color = Color.Red)
                .padding(horizontal = 16.dp, vertical = 8.dp)
            //Aplica algo curioso
            /*  .background(Color.LightGray)
              .border(width = 2.dp, color = Color.Blue)
              .padding(8.dp)*/
        )
    }
    //@Preview(showBackground = true, widthDp = 600, heightDp = 300)
    @Composable
    fun textoEstilo() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.lorem),
                fontStyle = FontStyle.Italic, //Inclinado, cursiva, etc
                fontWeight = FontWeight.Light, //Grado de marcado, si es fuerte o delgado
                fontSize = 16.sp, //Tamaño
                color = Color.Red, //Color rojo
                fontFamily = FontFamily.Monospace, //Tipo de letra
                letterSpacing = 5.sp, //Espacio entre cada letra
                textDecoration = TextDecoration.Underline, //Si tendrá un subrayado
                textAlign = TextAlign.Center, //Si el texto va en el centro, izquierda o derecha
                lineHeight = 2.em, //Espaciado tomando en cuenta la letra,
                maxLines = 4, //Cuantas lineas se pueden leer
                // softWrap = false, //Recorta palabra a medias si es true
                // overflow = TextOverflow.Ellipsis //Si el texto muestra ...
                // style =   TEMAAS EN EL ARCHIVO DE Type.kt, en los Theme.kt
                //style= MaterialTheme.typography.h4 //.copy( shadow= Shadow(offset=Offset(10f,10f),blurRadious=10f,color= Color.Black.copy(alpha=5f))
            )
        }
    }
}
/*
//Este es sola una función
//@Preview(showBackground = true, name="Android Prueba", widthDp = 400, heightDp = 200)
@Composable
fun DefaultPreview() {
    NierKaguyaTheme {
        Column{
            Greeting("Israel")
            Greeting("Realidad")
        }
    }
}*/