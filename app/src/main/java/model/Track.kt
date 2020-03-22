package model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Track(
    val id: String?,
    val title: String?,
    val title_short: String?,
    val link: String?,
    val preview: String?,
    val artist: Artist?,
    val album: Album?,
    val type: String?,
    val duration: String?,
    val track_position: String?
): Parcelable
/*
"id": 854914322,
"readable": true,
"title": "Godzilla",
"title_short": "Godzilla",
"title_version": "",
"link": "https://www.deezer.com/track/854914322",
"duration": 210,
"rank": 992465,
"explicit_lyrics": true,
"explicit_content_lyrics": 1,
"explicit_content_cover": 1,
"preview": "https://cdns-preview-d.dzcdn.net/stream/c-d5a91f3cf9c2b399c9734223623a3c67-4.mp3",
"artist": {},
"album": {},
"type": "track"
 */