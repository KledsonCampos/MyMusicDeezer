package repository

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(album: ALBUM): Long

    @Delete
    suspend fun delete(vararg album: ALBUM): Int

    @Query("SELECT * FROM Album")
    fun allFavorites(): Flow<List<ALBUM>>

    @Query("SELECT COUNT(id) FROM Album WHERE id = :id")
    suspend fun isFavorite(id: String): Int
}