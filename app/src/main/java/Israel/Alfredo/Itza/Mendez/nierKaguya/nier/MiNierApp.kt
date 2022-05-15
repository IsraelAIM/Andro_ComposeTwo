package Israel.Alfredo.Itza.Mendez.nierKaguya.nier

import Israel.Alfredo.Itza.Mendez.nierKaguya.ui.theme.NierKaguyaTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

//PRUEBA EXTRAÑA PENSADO EN CREAR UN COMPOSABLE CON LA BASE DE TU APP
@Composable
public fun MiNierApp(content: @Composable () -> Unit) {
    NierKaguyaTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}