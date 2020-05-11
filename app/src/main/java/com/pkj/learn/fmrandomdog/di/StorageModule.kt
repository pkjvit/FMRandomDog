package com.pkj.learn.fmrandomdog.di

import com.pkj.learn.fmrandomdog.data.source.local.DefaultDogsLocalDataSource
import com.pkj.learn.fmrandomdog.data.source.local.DogsLocalDataSource
import com.pkj.learn.fmrandomdog.data.source.local.cache.DogsCache
import com.pkj.learn.fmrandomdog.data.source.local.cache.Cache
import com.pkj.learn.fmrandomdog.data.source.remote.DefaultDogsRemoteDataSource
import com.pkj.learn.fmrandomdog.data.source.remote.DogsRemoteDataSource
import dagger.Binds
import dagger.Module

/**
 * @author Pankaj Jangid
 */
@Module
abstract class StorageModule {

    @Binds
    abstract fun provideLruStorage(storage: DogsCache): Cache

    @Binds
    abstract fun provideLocalDataSource(localDataSource: DefaultDogsLocalDataSource): DogsLocalDataSource

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSource: DefaultDogsRemoteDataSource): DogsRemoteDataSource


}