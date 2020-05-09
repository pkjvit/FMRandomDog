package com.pkj.learn.fmrandomdog.api

import androidx.lifecycle.LiveData
import com.pkj.learn.fmrandomdog.dog.DogResponse
import dagger.Provides
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import java.util.concurrent.Callable

/**
 * @author Pankaj Jangid
 */

interface DogApi {

    @GET("api/breeds/image/random")
    fun getRandomDog() : Single<DogResponse>
}