package com.pkj.learn.fmrandomdog.data.source.local

import androidx.room.*
import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.local.cache.DogsCache

/**
 * @author Pankaj Jangid
 */
@Dao
interface DogsDao {

    @Query("SELECT * FROM Dogs ORDER BY id LIMIT ${DogsCache.CACHE_SIZE}")
    suspend fun getDogs(): List<Dog>

    @Query("SELECT * FROM Dogs ORDER BY id DESC LIMIT 1")
    suspend fun getRecentDog(): Dog

    @Query("SELECT * FROM Dogs WHERE url = :url")
    suspend fun getDog(url: String): Dog

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog: Dog)

    @Query("SELECT COUNT(id) FROM Dogs")
    suspend fun size(): Int

    @Query("DELETE FROM Dogs WHERE id IN (SELECT id FROM Dogs limit 1)")
    suspend fun removeFirst()

    @Delete
    suspend fun removeDog(dog: Dog)

    @Query("DELETE FROM Dogs")
    suspend fun delete()



}