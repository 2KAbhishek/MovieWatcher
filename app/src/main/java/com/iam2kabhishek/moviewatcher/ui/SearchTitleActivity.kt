package com.iam2kabhishek.moviewatcher.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.iam2kabhishek.moviewatcher.R
import com.iam2kabhishek.moviewatcher.data.MovieRequests
import org.json.JSONObject
import java.lang.StringBuilder

class SearchTitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_title)

        // Allow network activity on main thread
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val editTextTitles = findViewById<EditText>(R.id.editTextTitles)
        val buttonTriggerSearchTitle = findViewById<Button>(R.id.buttonTriggerSearchTitle)
        val textTitleSearchResults = findViewById<TextView>(R.id.textTitleSearchResults)

        buttonTriggerSearchTitle.setOnClickListener{
            val input = editTextTitles.text.toString()
            val searchAllTitles = "s=$input"
            val searchResults = MovieRequests(searchAllTitles).run()
            val searchResultJson = JSONObject(searchResults)
            val moviesArray = searchResultJson.optJSONArray("Search")
            val result = StringBuilder()
            for (i in 0 until moviesArray.length()) {
                val movie = moviesArray.getJSONObject(i)
                result.append("\n${movie.getString("Title")}\n${movie.getString("Year")}\n")
            }
            textTitleSearchResults.text = result.toString()
        }
    }
}