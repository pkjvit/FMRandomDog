package com.pkj.learn.fmrandomdog.ui.recentsdog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pkj.learn.fmrandomdog.dog.DogRepository
import javax.inject.Inject

class RecentDogsViewModel @Inject constructor(private val repository: DogRepository) : ViewModel() {

    private val _recentDogs: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val recentDogs: LiveData<ArrayList<String>> = _recentDogs

    fun getRecentDogs(){
        _recentDogs.value = repository.getRecentDogs()
    }

    fun clear(){
        repository.clear()
        getRecentDogs()
    }
}
