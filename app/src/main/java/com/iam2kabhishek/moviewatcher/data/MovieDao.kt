package com.iam2kabhishek.moviewatcher.data

import androidx.room.*

@Dao
interface MovieDao {
    @Insert
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM movies WHERE actors LIKE '%' || :search || '%'")
    fun loadActorMovies(search: String?): List<Movie>
}