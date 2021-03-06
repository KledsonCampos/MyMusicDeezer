package model

import java.io.Serializable

data class Artist(
    val id: String?,
    val name: String?,
    val link: String?,
    val picture: String?,
    val picture_small: String?,
    val picture_medium: String?,
    val picture_big: String?
): Serializable
/*
"artist": {
    "id": 13,
    "name": "Eminem",
    "link": "https://www.deezer.com/artist/13",
    "picture": "https://api.deezer.com/artist/13/image",
    "picture_small": "https://e-cdns-images.dzcdn.net/images/artist/0707267475580b1b82f4da20a1b295c6/56x56-000000-80-0-0.jpg",
    "picture_medium": "https://e-cdns-images.dzcdn.net/images/artist/0707267475580b1b82f4da20a1b295c6/250x250-000000-80-0-0.jpg",
    "picture_big": "https://e-cdns-images.dzcdn.net/images/artist/0707267475580b1b82f4da20a1b295c6/500x500-000000-80-0-0.jpg",
    "picture_xl": "https://e-cdns-images.dzcdn.net/images/artist/0707267475580b1b82f4da20a1b295c6/1000x1000-000000-80-0-0.jpg",
    "tracklist": "https://api.deezer.com/artist/13/top?limit=50",
    "type": "artist"
},
        */