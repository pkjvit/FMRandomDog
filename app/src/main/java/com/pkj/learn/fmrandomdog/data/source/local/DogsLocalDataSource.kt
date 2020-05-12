package com.pkj.learn.fmrandomdog.data.source.local

import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.remote.DogResponse

/**
 * @author Pankaj Jangid
 */
interface DogsLocalDataSource {

    suspend fun putInStorage(dogResponse: DogResponse)

    suspend fun getRecentDogs(): List<Dog>

    suspend fun getRecentDog(): Dog

    suspend fun clear()

}