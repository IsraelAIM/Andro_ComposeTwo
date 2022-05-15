package Israel.Alfredo.Itza.Mendez.nierKaguya.nier

import Israel.Alfredo.Itza.Mendez.nierKaguya.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
//ESTE CODIGO NO ES IMPORTANTE

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