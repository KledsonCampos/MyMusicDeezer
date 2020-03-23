package repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.Album

class AlbumRepository(context: Context) {
    private val dao: AlbumDao = AppDatabase.getDatabase(context).getAlbumDao()

    suspend fun save(album: Album) {
        dao.save(AlbumDBAlbumMapper.AlbumToAlbumDB(album))
    }

    suspend fun delete(album: Album) {
        dao.delete(AlbumDBAlbumMapper.AlbumToAlbumDB(album))
    }

    suspend fun isFavolite(id: String): Boolean {
        return dao.isFavorite(id) > 0
    }

    fun allFavorites(): Flow<List<Album>> {
        return dao.allFavorites()
            .map { albumDbList ->
                   albumDbList.map {albumDB ->
                       AlbumDBAlbumMapper.AlbumDBToAlbum(albumDB)
                   }
            }
    }
}