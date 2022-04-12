package com.iam2kabhishek.moviewatcher.ui

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.iam2kabhishek.moviewatcher.R
import com.iam2kabhishek.moviewatcher.data.Movie
import com.iam2kabhishek.moviewatcher.data.MovieRequests
import org.json.JSONObject


class SearchMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        // Allow network activity on main thread
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val buttonTriggerSearch = findViewById<Button>(R.id.buttonTriggerSearch)
        val editTextMovie = findViewById<EditText>(R.id.editTextMovie)
        val textMovieDetails = findViewById<TextView>(R.id.textMovieDetails)
        var searchedNMovie: Movie

        buttonTriggerSearch.setOnClickListener {
            val input = editTextMovie.text.toString()
            val searchByTitle = "t=$input"
            val movieRes = MovieRequests(searchByTitle).run()
            val movieJson = JSONObject(movieRes)

            searchedNMovie = Movie(
                movieJson.getString("Title"),
                movieJson.getString("Year"),
                movieJson.getString("Rated"),
                movieJson.getString("Released"),
                movieJson.getString("Runtime"),
                movieJson.getString("Genre"),
                movieJson.getString("Director"),
                movieJson.getString("Writer"),
                movieJson.getString("Actors"),
                movieJson.getString("Plot"),
            )

            textMovieDetails.text = searchedNMovie.toString()
        }

    }

    private fun getEmptyMovie(): Movie {
        return Movie("", "", "", "", "", "",
            "", "", "", "")
    }

}