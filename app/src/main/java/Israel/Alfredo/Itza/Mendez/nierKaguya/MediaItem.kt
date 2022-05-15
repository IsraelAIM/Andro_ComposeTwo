package Israel.Alfredo.Itza.Mendez.nierKaguya

import Israel.Alfredo.Itza.Mendez.nierKaguya.MediaItem.Type

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
){
    enum class Type {PHOTO, VIDEO}
}

fun getMedia() = (1..20).map{
    MediaItem(
        id = it,
        title = "Se busca Gatotraficante: $it",
        thumb = "https://loremflickr.com/320/240?lock=$it",
        type = if(it % 3 == 0) Type.VIDEO else Type.PHOTO
    )
}