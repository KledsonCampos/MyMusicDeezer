package repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
@TypeConverters(StringListConverter::class)
data class ALBUM(
    @PrimaryKey
    val id: String,
    val title: String,
    val descriptor: String?,
    val cover_big: String?,
    val nb_tracks: String?,
    val artist: List<String>?,
    val tracklist: List<String>?
)