package com.pkj.learn.fmrandomdog.data.source

import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.local.DogsLocalDataSource
import com.pkj.learn.fmrandomdog.data.source.remote.DogResponse
import com.pkj.learn.fmrandomdog.data.source.remote.DogsRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Pankaj Jangid
 */

class DefaultDogRepository @Inject constructor(private val dogsLocalDataSource: DogsLocalDataSource,
                                               private val dogsRemoteDataSource: DogsRemoteDataSource) : DogsRepository {
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    override suspend fun getRandomDog() = withContext(ioDispatcher){
        val dogResponse = dogsRemoteDataSource.getRandomDog()
        putInStorage(dogResponse)
    }

    override suspend fun putInStorage(dogResponse: DogResponse) = withContext(ioDispatcher){
        dogsLocalDataSource.putInStorage(dogResponse)
    }

    override suspend fun getRecentDogs(): List<Dog> {
        return dogsLocalDataSource.getRecentDogs()
    }

    override suspend fun getRecentDog(): Dog {
        return dogsLocalDataSource.getRecentDog()
    }

    override suspend fun clear() = withContext(ioDispatcher){
        dogsLocalDataSource.clear()
    }
}