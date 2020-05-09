package com.pkj.learn.fmrandomdog.ui.generatedog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pkj.learn.fmrandomdog.dog.DogRepository
import com.pkj.learn.fmrandomdog.dog.DogResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GenerateDogViewModel @Inject constructor(private val repository: DogRepository) : ViewModel() {

    private val _response: MutableLiveData<DogResponse> = MutableLiveData()
    val response: LiveData<DogResponse> = _response

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    val bag: CompositeDisposable = CompositeDisposable()

    fun getRandomDog(){
        _isLoading.value = true
        bag.add(
            repository.getRandomDog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    _response.value = it
                    repository.putInStorage(it)
                    _isLoading.value = false
                })
        )
//        _response.value = DogResponse("https://images.dog.ceo/breeds/bluetick/n02088632_819.jpg", "Success")
    }

    override fun onCleared() {
        bag.dispose()
        super.onCleared()
    }

}
