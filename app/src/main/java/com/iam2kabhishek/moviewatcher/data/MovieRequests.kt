package com.iam2kabhishek.moviewatcher.data

import android.util.Log
import java.net.URL

class MovieRequests(private val param: String) {
    fun run() {
        val url = "https://www.omdbapi.com/?$param&apikey=f05230c0"
        val movieJson = URL(url).readText()
        Log.d("Movie response", movieJson)
    }
}