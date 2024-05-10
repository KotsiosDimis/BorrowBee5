package com.example.borrowbee.apis

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

// Function to fetch book image by ISBN
fun fetchBookImage(isbn: Long, callback: (Bitmap?) -> Unit) {
    val apiUrl = "https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn"

    GlobalScope.launch(Dispatchers.IO) {
        try {
            val url = URL(apiUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = BufferedInputStream(connection.inputStream)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                inputStream.close()

                callback(bitmap)
            } else {
                // Handle HTTP error
                callback(null)
            }
        } catch (e: IOException) {
            // Handle network errors
            callback(null)
        }
    }
}