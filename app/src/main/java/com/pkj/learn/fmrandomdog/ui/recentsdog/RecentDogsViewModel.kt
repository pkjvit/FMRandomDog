package com.pkj.learn.fmrandomdog.ui.recentsdog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.DefaultDogRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecentDogsViewModel @Inject constructor(private val repository: DefaultDogRepository) : ViewModel() {

    private var _recentDogs: MutableLiveData<List<Dog>> = MutableLiveData()
    val recentDogs: LiveData<List<Dog>> = _recentDogs

    fun getRecentDogs(){
        viewModelScope.launch {
            _recentDogs.value = repository.getRecentDogs()
        }
    }

    fun clear(){
        viewModelScope.launch {
            repository.clear()
            _recentDogs.value = emptyList()
        }
    }
}
