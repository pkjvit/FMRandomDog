package com.pkj.learn.fmrandomdog.data.source

import androidx.lifecycle.LiveData
import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.remote.DogResponse
import io.reactivex.Single

/**
 * @author Pankaj Jangid
 */
interface DogsRepository {

    suspend fun getRandomDog()

    suspend fun putInStorage(dogResponse: DogResponse)

    suspend fun getRecentDogs(): List<Dog>

    suspend fun getRecentDog(): Dog

    suspend fun clear()
}