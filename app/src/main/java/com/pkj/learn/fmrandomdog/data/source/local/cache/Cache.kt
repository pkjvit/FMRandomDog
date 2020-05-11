package com.pkj.learn.fmrandomdog.data.source.local.cache

import androidx.lifecycle.LiveData
import com.pkj.learn.fmrandomdog.data.Dog

/**
 * @author Pankaj Jangid
 */
interface Cache {

    fun put(dogUrl : String)

    fun putAll(dogs : List<Dog>)

    fun getRecentDogs() : List<Dog>

    fun getRecentDog() : Dog

    fun clear()
}