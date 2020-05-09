package com.pkj.learn.fmrandomdog.di

import com.pkj.learn.fmrandomdog.api.DogApi
import com.pkj.learn.fmrandomdog.storage.LruStorage
import com.pkj.learn.fmrandomdog.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Pankaj Jangid
 */
@Module
class AppModule {
    //https://dog.ceo/api/breeds/image/random

    @Provides
    fun provideDogApi() : DogApi{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DogApi::class.java)

    }
}