package com.iam2kabhishek.moviewatcher

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieDb = MovieDatabase.getInstance(this)
        val movieDao = movieDb.movieDao()

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        buttonAdd.setOnClickListener {
            val classicMovies = MovieData.getClassicMovies()
            try {
                for (movie in classicMovies)
                    movieDao.insert(movie)
                Toast.makeText(this, "Classic movies added to DB", Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                Toast.makeText(this, "Movies already added!", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonSearchMovies = findViewById<Button>(R.id.buttonSearchMovies)
        buttonSearchMovies.setOnClickListener {
            val searchMovieIntent = Intent(this, SearchMovieActivity::class.java)
            startActivity(searchMovieIntent)
        }

        val buttonSearchActors = findViewById<Button>(R.id.buttonSearchActors)
        buttonSearchActors.setOnClickListener {
            val searchActorIntent = Intent(this, SearchActorsActivity::class.java)
            startActivity(searchActorIntent)
        }
    }
}