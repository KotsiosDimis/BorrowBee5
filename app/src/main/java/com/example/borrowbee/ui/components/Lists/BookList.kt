package com.example.borrowbee.ui.components.Lists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.borrowbee.data.models.BookModel

@Composable
fun BookList(bookModels: List<BookModel>, onItemClick: (BookModel) -> Unit) {
    LazyColumn {
        items(bookModels) { book ->
            BookItem(bookModel = book, onItemClick = onItemClick)
        }
    }
}

@Composable
fun BookItem(bookModel: BookModel, onItemClick: (BookModel) -> Unit) {
    // UI for displaying a single book item
    Text(text = bookModel.title, modifier = Modifier.clickable { onItemClick(bookModel) })
}