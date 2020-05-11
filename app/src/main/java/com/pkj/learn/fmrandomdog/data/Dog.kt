package com.pkj.learn.fmrandomdog.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Pankaj Jangid
 */
@Entity(tableName = "dogs")
data class Dog @JvmOverloads constructor(

    @ColumnInfo(name = "url") val url: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0
)