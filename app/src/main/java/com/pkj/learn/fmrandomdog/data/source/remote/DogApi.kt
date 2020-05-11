package com.pkj.learn.fmrandomdog.data.source.remote

import com.pkj.learn.fmrandomdog.data.source.remote.DogResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author Pankaj Jangid
 */

interface DogApi {

    @GET("api/breeds/image/random")
    suspend fun getRandomDog() : DogResponse
}