package com.iam2kabhishek.moviewatcher.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.iam2kabhishek.moviewatcher.R
import com.iam2kabhishek.moviewatcher.data.MovieDatabase

class SearchActorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_actor)

        val movieDb = MovieDatabase.getInstance(this)
        val movieDao = movieDb.movieDao()

        val editTextActor = findViewById<EditText>(R.id.editTextActor)
        val buttonTriggerSearchActor = findViewById<Button>(R.id.buttonTriggerSearchActor)
        val textSearchResults = findViewById<TextView>(R.id.textSearchResults)

        buttonTriggerSearchActor.setOnClickListener {
            val searchQuery = editTextActor.text.toString()
            val movieResults = movieDao.loadActorMovies(searchQuery)
            var searchResults = ""

            for (movie in movieResults) {
                searchResults += "$movie\n\n"
            }

            textSearchResults.text = searchResults
        }
    }
}