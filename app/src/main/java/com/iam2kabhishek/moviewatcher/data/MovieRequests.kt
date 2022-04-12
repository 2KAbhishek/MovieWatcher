package com.iam2kabhishek.moviewatcher.data

import android.util.Log
import com.iam2kabhishek.moviewatcher.BuildConfig
import java.net.URL

class MovieRequests(private val param: String) {
    fun run(): String {
        val apiKey = BuildConfig.API_KEY
        val url = "https://www.omdbapi.com/?$param&apikey=$apiKey"
        val movieJson = URL(url).readText()
        Log.d("Movie response", movieJson)
        return movieJson
    }
}