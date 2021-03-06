package com.pkj.learn.fmrandomdog.ui.generatedog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pkj.learn.fmrandomdog.data.Dog
import com.pkj.learn.fmrandomdog.data.source.DefaultDogRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class GenerateDogViewModel @Inject constructor(private val repository: DefaultDogRepository) : ViewModel() {

    private val _response: MutableLiveData<Dog> = MutableLiveData()
    val response: LiveData<Dog> = _response

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getRandomDog(){
        _isLoading.value = true
        viewModelScope.launch {
            repository.getRandomDog()
            _response.value = repository.getRecentDog()
            _isLoading.value = false
        }
    }


}
