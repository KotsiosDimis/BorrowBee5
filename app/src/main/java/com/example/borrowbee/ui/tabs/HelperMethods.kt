package com.example.borrowbee.ui.tabs

import BookComponent2
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.main.BookDetailActivity
import com.example.borrowbee.main.BookDetailActivity2
import com.example.borrowbee.ui.components.bookComponent.BookComponent

fun openBookDetailsActivity(context: Context, bookEntity: BookEntity, isBookmarked: Boolean = false) {
    val intent = Intent(context, BookDetailActivity::class.java).apply {

        putExtra(key_book, bookEntity)
        putExtra(key_is_bookmarked, isBookmarked)
    }
    context.startActivity(intent)
}

fun openBookDetailsActivity2(context: Context, book: Book, isBookmarked: Boolean = false) {
    val intent = Intent(context, BookDetailActivity2::class.java).apply {

        putExtra(key_book2, book)
        putExtra(key_is_bookmarked, isBookmarked)
    }
    context.startActivity(intent)
}

@Composable
fun BooksList(bookList: Array<BookEntity>) {
    LazyRow {
        items(bookList) { book ->
            BookComponent(bookEntity = book)
        }
    }
}


@Composable
fun BooksColumn(bookList: Array<BookEntity>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(120.dp)) {
        items(bookList.size) { index ->
            BookComponent(bookEntity = bookList[index])
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun BooksColumn2(bookList: Array<Book>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(120.dp)) {
        items(bookList.size) { index ->
            BookComponent2(book = bookList[index])
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