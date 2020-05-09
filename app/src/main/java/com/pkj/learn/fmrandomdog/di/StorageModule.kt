package com.pkj.learn.fmrandomdog.di

import com.pkj.learn.fmrandomdog.storage.LruStorage
import com.pkj.learn.fmrandomdog.storage.Storage
import dagger.Binds
import dagger.Module

/**
 * @author Pankaj Jangid
 */
@Module
abstract class StorageModule {

    @Binds
    abstract fun provideLruStorage(storage: LruStorage): Storage

}