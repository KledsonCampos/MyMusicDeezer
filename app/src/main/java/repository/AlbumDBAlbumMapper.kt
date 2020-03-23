package repository

import model.Album
import model.Artist

object AlbumDBAlbumMapper {
    fun AlbumDBToAlbum(albumdb: AlbumDB) =
        Album(
            albumdb.id,
            albumdb.title,
            albumdb.cover,
            albumdb.cover_small,
            albumdb.cover_medium,
            albumdb.cover_big,
            albumdb.type,
            albumdb.nb_tracks,
            Artist(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            ),
            albumdb.tracklist,
            albumdb.record_type
        )

    fun AlbumToAlbumDB(album: Album) =
        album.run {
            AlbumDB(
                album.id!!,
                album.title,
                album.cover,
                album.cover_small,
                album.cover_medium,
                album.cover_big,
                album.record_type,
                album.nb_tracks,
                album.tracklist,
                album.record_type
            )
        }
}