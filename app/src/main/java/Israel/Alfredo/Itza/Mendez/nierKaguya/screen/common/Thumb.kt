package Israel.Alfredo.Itza.Mendez.nierKaguya.screen.common

import Israel.Alfredo.Itza.Mendez.nierKaguya.R
import Israel.Alfredo.Itza.Mendez.nierKaguya.model.MediaItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun Thumb(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.cell_thumb_height))
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(data = mediaItem.thumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (mediaItem.type == MediaItem.Type.VIDEO) {
            Icon(
                Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.cell_play_icon_size))
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}