package repository

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(album: AlbumDB): Long

    @Delete
    suspend fun delete(vararg album: AlbumDB): Int

    @Query("SELECT * FROM AlbumDB")
    fun allFavorites(): Flow<List<AlbumDB>>

    @Query("SELECT COUNT(id) FROM AlbumDB WHERE id = :id")
    suspend fun isFavorite(id: String): Int
}