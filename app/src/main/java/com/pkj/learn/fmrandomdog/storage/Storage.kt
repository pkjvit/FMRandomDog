package com.pkj.learn.fmrandomdog.storage

/**
 * @author Pankaj Jangid
 */
interface Storage {

    fun put(dogUrl : String)

    fun getRecentDogs() : ArrayList<String>

    fun clear()
}