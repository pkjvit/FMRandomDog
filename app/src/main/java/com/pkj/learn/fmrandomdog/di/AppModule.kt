package com.pkj.learn.fmrandomdog.di

import android.content.Context
import androidx.room.Room
import com.pkj.learn.fmrandomdog.data.source.local.DogsDao
import com.pkj.learn.fmrandomdog.data.source.local.DogsDatabase
import com.pkj.learn.fmrandomdog.data.source.remote.DogApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Pankaj Jangid
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDogApi() : DogApi {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DogApi::class.java)

    }

    @Singleton
    @Provides
    fun provideDb(context: Context): DogsDatabase {
        return Room
            .databaseBuilder(context, DogsDatabase::class.java, "dogs.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDogsDao(db: DogsDatabase): DogsDao {
        return db.dogsDao()
    }

//    @Provides
//    fun provideCoroutineDispatcher(coroutineDispatcher: CoroutineDispatcher): CoroutineDispatcher{
//        return Dispatchers.IO
//    }
}