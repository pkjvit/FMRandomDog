package com.pkj.learn.fmrandomdog.data.source.local.cache

import android.util.LruCache
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pkj.learn.fmrandomdog.data.Dog
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Pankaj Jangid
 */
@Singleton
class DogsCache @Inject constructor() : Cache {

    companion object {
        const val CACHE_SIZE = 4
    }

    private val lruCache : LruCache<String, Dog> = LruCache(Companion.CACHE_SIZE)

    override fun put(dogUrl: String) {
        lruCache.put(dogUrl, Dog(dogUrl))
    }

    override fun putAll(dogs: List<Dog>) {
        for (dog in dogs){
            lruCache.put(dog.url, dog)
        }
    }

    override fun getRecentDogs(): List<Dog> {
        return ArrayList(lruCache.snapshot().values.reversed())
    }

    override fun getRecentDog(): Dog {
        return lruCache.snapshot().values.last()
    }

    override fun clear() {
        lruCache.evictAll()
    }


}