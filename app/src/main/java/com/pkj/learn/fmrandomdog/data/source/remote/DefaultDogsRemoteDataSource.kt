package com.pkj.learn.fmrandomdog.data.source.remote

import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Pankaj Jangid
 */
class DefaultDogsRemoteDataSource @Inject constructor(private val api: DogApi) : DogsRemoteDataSource {
    override suspend fun getRandomDog(): DogResponse {
        return api.getRandomDog()
    }
}