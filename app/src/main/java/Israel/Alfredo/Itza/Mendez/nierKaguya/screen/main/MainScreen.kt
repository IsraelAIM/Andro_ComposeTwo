package Israel.Alfredo.Itza.Mendez.nierKaguya.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        MediaXList(modifier = Modifier.padding(padding))
    }
}