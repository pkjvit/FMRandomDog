package com.pkj.learn.fmrandomdog.data.source.local

import androidx.lifecycle.LiveData
import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.local.cache.Cache
import com.pkj.learn.fmrandomdog.data.source.local.cache.DogsCache
import com.pkj.learn.fmrandomdog.data.source.remote.DogResponse
import javax.inject.Inject

/**
 * @author Pankaj Jangid
 */
class DefaultDogsLocalDataSource @Inject constructor(private val dogsDao: DogsDao, private val storage: Cache) : DogsLocalDataSource {

    override suspend fun putInStorage(dogResponse: DogResponse) {
        val url = dogResponse.message
        dogsDao.getDog(url)?.let{
            dogsDao.removeDog(it)
            dogsDao.insertDog(it)
        }
        if(dogsDao.size() >= DogsCache.CACHE_SIZE-1){
            dogsDao.removeFirst()
        }
        dogsDao.insertDog(Dog(url))
        updateCacheFromDb()
        storage.put(url)
    }

    private suspend fun updateCacheFromDb(){
        if(storage.getRecentDogs().isNullOrEmpty()){
            storage.putAll(dogsDao.getDogs())
        }
    }

    override suspend fun getRecentDogs(): List<Dog> {
        updateCacheFromDb()
        return storage.getRecentDogs()
    }

    override suspend fun getRecentDog(): Dog {
        return dogsDao.getRecentDog()
    }

    override suspend fun clear() {
        dogsDao.delete()
        storage.clear()
    }
}