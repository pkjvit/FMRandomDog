package com.pkj.learn.fmrandomdog.storage

import android.util.LruCache
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Pankaj Jangid
 */
@Singleton
class LruStorage @Inject constructor() : Storage {

    companion object {
        const val CACHE_SIZE = 4
    }

    private val lruCache : LruCache<String, String> = LruCache(Companion.CACHE_SIZE)

    override fun put(dogUrl: String) {
        lruCache.put(dogUrl, dogUrl)
    }

    override fun getRecentDogs(): ArrayList<String> {
        return ArrayList(lruCache.snapshot().values.reversed())
    }

    override fun clear() {
        lruCache.evictAll()
    }


}