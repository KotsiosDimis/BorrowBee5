package com.example.borrowbee.ui.tabs

import BookComponent
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.main.BookDetailActivity

const val key_book = "key_book"
const val key_is_bookmarked = "key_is_bookmarked"

fun openBookDetailsActivity(context: Context, book: Book, isBookmarked: Boolean = false) {
    val intent = Intent(context, BookDetailActivity::class.java).apply {

        putExtra(key_book, book)
        putExtra(key_is_bookmarked, isBookmarked)
    }
    context.startActivity(intent)
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun BooksColumn(bookList: Array<Book>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(120.dp)) {
        items(bookList.size) { index ->
            BookComponent(book = bookList[index])
        }
    }
}

fun fixUrl(url: String?): String? {
    if (url == null) {
        return null
    }
    return if (url.startsWith("http:")) {
        "https" + url.substring(4)
    } else {
        url
    }
}