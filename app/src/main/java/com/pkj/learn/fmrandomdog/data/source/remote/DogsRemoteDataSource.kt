package com.pkj.learn.fmrandomdog.data.source.remote

import io.reactivex.Single

/**
 * @author Pankaj Jangid
 */
interface DogsRemoteDataSource {

    suspend fun getRandomDog() : DogResponse

}