package com.pkj.learn.fmrandomdog.dog

import android.content.Context
import androidx.lifecycle.LiveData
import com.pkj.learn.fmrandomdog.api.DogApi
import com.pkj.learn.fmrandomdog.storage.Storage
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Pankaj Jangid
 */

class DogRepository @Inject constructor(private val dogApi: DogApi, private val storage: Storage) {

    fun getRandomDog() : Single<DogResponse>{
        return dogApi.getRandomDog()
    }

    fun putInStorage(dogResponse: DogResponse){
        storage.put(dogResponse.message)
    }

    fun getRecentDogs(): ArrayList<String>{
        return storage.getRecentDogs()
    }

    fun clear(){
        storage.clear()
    }
}