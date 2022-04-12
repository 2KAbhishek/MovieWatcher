package com.iam2kabhishek.moviewatcher.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = false) val title: String,
    val year: String,
    val rated: String,
    val released: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val writer: String,
    val actors: String,
    val plot: String,
) {
    override fun toString(): String {
        return "Movie\nTitle:\t$title\nRated:\t$rated\nReleased:\t$released\nRuntime:\t$runtime\n" +
                "Genre:\t$genre\nDirector:\t$director\nWriter:\t$writer\nActors:\t$actors" +
                "\nPlot:\t$plot"
    }
}
