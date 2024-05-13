package com.example.borrowbee.apis

import com.example.borrowbee.data.entities.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

suspend fun fetchBookDetails(isbn13: String): Book? {
    val client = OkHttpClient()
    val url = "https://www.googleapis.com/books/v1/volumes?q=isbn:$isbn13"
    val request = Request.Builder().url(url).build()

    return withContext(Dispatchers.IO) {
        val response = client.newCall(request).execute()
        val responseBody = response.body?.string()
        response.close()

        if (response.isSuccessful && !responseBody.isNullOrBlank()) {
            val jsonObject = JSONObject(responseBody)
            val items = jsonObject.optJSONArray("items")
            if (items != null && items.length() > 0) {
                val item = items.getJSONObject(0)
                val volumeInfo = item.optJSONObject("volumeInfo")
                if (volumeInfo != null) {
                    val title = volumeInfo.optString("title", "")
                    val authorsArray = volumeInfo.optJSONArray("authors")
                    val author = if (authorsArray != null && authorsArray.length() > 0) {
                        authorsArray.getString(0)
                    } else {
                        ""
                    }
                    val publisher = volumeInfo.optString("publisher", "")
                    val publicationDate = volumeInfo.optString("publishedDate", "")
                    val imageUrl = volumeInfo.optJSONObject("imageLinks")?.optString("thumbnail", null)

                    Book(isbn13 = isbn13, title = title, author = author, publisher = publisher, publicationDate = publicationDate, imageUrl = imageUrl)

                } else {
                    null
                }
            } else {
                null
            }
        } else {
            null
        }
    }
}
