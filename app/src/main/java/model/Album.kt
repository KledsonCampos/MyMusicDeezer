package model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Album(
    val id: String,
    val title: String?,
    val cover: String?,
    val cover_small: String?,
    val cover_medium: String?,
    val cover_big: String?,
    val type: String?,
    val nb_tracks: String?,
    val artist: Artist?,
    val tracklist: String?,
    val record_type: String?
): Parcelable


/*
   "title": "Curtain Call: The Hits",
   "cover": "https://api.deezer.com/album/119606/image",
   "cover_small": "https://e-cdns-images.dzcdn.net/images/cover/e2b36a9fda865cb2e9ed1476b6291a7d/56x56-000000-80-0-0.jpg",
   "cover_medium": "https://e-cdns-images.dzcdn.net/images/cover/e2b36a9fda865cb2e9ed1476b6291a7d/250x250-000000-80-0-0.jpg",
   "cover_big": "https://e-cdns-images.dzcdn.net/images/cover/e2b36a9fda865cb2e9ed1476b6291a7d/500x500-000000-80-0-0.jpg",
   "cover_xl": "https://e-cdns-images.dzcdn.net/images/cover/e2b36a9fda865cb2e9ed1476b6291a7d/1000x1000-000000-80-0-0.jpg",
   "tracklist": "https://api.deezer.com/album/119606/tracks",
   "type": "album"
 */

