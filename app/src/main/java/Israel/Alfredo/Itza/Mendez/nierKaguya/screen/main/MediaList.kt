package Israel.Alfredo.Itza.Mendez.nierKaguya.screen.main

import Israel.Alfredo.Itza.Mendez.nierKaguya.R
import Israel.Alfredo.Itza.Mendez.nierKaguya.model.MediaItem
import Israel.Alfredo.Itza.Mendez.nierKaguya.model.getMedia
import Israel.Alfredo.Itza.Mendez.nierKaguya.screen.common.Thumb
import Israel.Alfredo.Itza.Mendez.nierKaguya.screen.common.Title
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi

/*
//IDEA DE UNA PRUEBA CERCANA A LA REALIDAD
@ExperimentalFoundationApi
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaYList(modifier: Modifier = Modifier) {
    MiNierApp {
        LazyVerticalGrid(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
            cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
            modifier = modifier
        ) {
            items(getMedia()) { item ->
                MediaVGListItem(
                    item,
                    navController,
                    Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
                )
            }
        }
    }
}
*/
//Prueba con el ToolAppBar pasandole un parametro
@ExperimentalFoundationApi
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaXList(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaVGListItem(
                item = item,
                navController,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
            )
        }
    }
}

/* FUNCION PARA ESTADO
//@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable //Recibir parametros no permite el uso de Previews
fun EstadoSample(value: String, onValueChange: (String) -> Unit) {
    // var text by remember{ mutableStateOf("")}
    //Linea que permite guardar info al rotar el movil y otra m??s

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
 */
/*
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
            MediaVGListItem(item, navController, Modifier.padding(2.dp))
        }
    }
}
*/
@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaVGListItem(
    item: MediaItem,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable {
            navController.navigate("detail/${item.id}") },
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray),
        //backgroundColor = MaterialTheme.colors.primary,
        //contentColor = MaterialTheme.colors.secondary
        //shape = RoundedCornerShape(16.dp)
        ) {
        Column {
            Thumb(item)
            Title(item)
        }
    }


}

//FIN VERTICAL GRID
/*
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
            if (item.type == MediaItem.Type.VIDEO) {
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
*/
//FIN VERTICAL
/*
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
            if (item.type == MediaItem.Type.VIDEO) {
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
//FIN HORIZONTAL
*/
