package com.example.borrowbee.apis

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

// Function to fetch book description by ISBN
fun fetchBookDescription(isbn: Long, callback: (String?) -> Unit) {
    val apiUrl = "https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn"

    GlobalScope.launch(Dispatchers.IO) {
        try {
            val url = URL(apiUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuilder()
                var line: String? = reader.readLine()
                while (line != null) {
                    response.append(line)
                    line = reader.readLine()
                }
                reader.close()

                // Parse JSON response
                val jsonResponse = JSONObject(response.toString())
                val items = jsonResponse.getJSONArray("items")
                if (items.length() > 0) {
                    val volumeInfo = items.getJSONObject(0).getJSONObject("volumeInfo")
                    val description = volumeInfo.optString("description", null)
                    callback(description)
                } else {
                    callback(null) // No book found with given ISBN
                }
            } else {
                // Handle HTTP error
                callback(null)
            }
        } catch (e: Exception) {
            // Handle network or JSON parsing errors
            callback(null)
        }
    }
}
