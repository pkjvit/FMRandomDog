package com.pkj.learn.fmrandomdog

import android.app.Application
import com.pkj.learn.fmrandomdog.di.AppComponent
import com.pkj.learn.fmrandomdog.di.DaggerAppComponent

/**
 * @author Pankaj Jangid
 */
class DogApp : Application() {

    val appComponent:AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}