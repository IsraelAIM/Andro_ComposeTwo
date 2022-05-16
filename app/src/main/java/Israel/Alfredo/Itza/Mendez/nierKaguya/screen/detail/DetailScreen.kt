package Israel.Alfredo.Itza.Mendez.nierKaguya.screen.detail

import Israel.Alfredo.Itza.Mendez.nierKaguya.model.getMedia
import Israel.Alfredo.Itza.Mendez.nierKaguya.screen.common.Thumb
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
//@Preview(showBackground = true, widthDp = 400, heightDp = 400)
fun DetailScreen(mediaId: Int) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = mediaItem.title) })
        }
    ) { padding->
        Thumb(mediaItem = mediaItem, Modifier.padding(padding))
    }
}