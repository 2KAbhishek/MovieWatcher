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
        return "Movie\nTitle:$title\nRated:$rated\nReleased:$released\nRuntime:$runtime\n" +
                "Genre:$genre\nDirector:$director\nWriter:$writer\nActors:$actors\nPlot:$plot"
    }
}
