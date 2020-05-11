package com.pkj.learn.fmrandomdog.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pkj.learn.fmrandomdog.data.Dog

/**
 * @author Pankaj Jangid
 */
@Database(entities = [Dog::class], version = 1, exportSchema = false)
abstract class DogsDatabase: RoomDatabase() {

    abstract fun dogsDao(): DogsDao

}