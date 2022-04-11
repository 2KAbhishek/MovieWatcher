package com.iam2kabhishek.moviewatcher

import androidx.room.*

@Dao
interface MovieDao {
    @Insert
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Delete
    fun delete(movie: Movie)
}