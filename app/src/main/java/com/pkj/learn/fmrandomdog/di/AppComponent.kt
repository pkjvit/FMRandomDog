package com.pkj.learn.fmrandomdog.di

import android.content.Context
import com.pkj.learn.fmrandomdog.ui.generatedog.GenerateDogFragment
import com.pkj.learn.fmrandomdog.ui.recentsdog.RecentDogsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Pankaj Jangid
 */
@Singleton
@Component(modules = [AppModule::class, StorageModule::class])
interface AppComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }

    fun inject(fragment: GenerateDogFragment)

    fun inject(fragment: RecentDogsFragment)
}