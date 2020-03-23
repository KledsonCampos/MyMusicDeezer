package repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import model.Artist

@Entity
@TypeConverters(StringListConverter::class)
data class AlbumDB(
    @PrimaryKey
    val id: String,
    val title: String?,
    val cover: String?,
    val cover_small: String?,
    val cover_medium: String?,
    val cover_big: String?,
    val type: String?,
    val nb_tracks: String?,
    //val artist: List<String>?,
    val tracklist: String?,
    val record_type: String?
)