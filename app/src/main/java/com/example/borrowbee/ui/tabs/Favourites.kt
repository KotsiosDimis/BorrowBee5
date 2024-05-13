package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.borrowbee.main.MyViewModel

@Composable
fun FavouritesTab() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 12.dp,
                end = 12.dp
            ),
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            val viewModel: MyViewModel = viewModel()
            val roomBooks by viewModel.roomBooks.collectAsState()

            // Trigger fetching books from the database when HomeTab composable is initially composed
            LaunchedEffect(Unit) {
                // Fetch books using the view model
                viewModel.fetchFavoriteBooks(1)
            }
            val booksArray = roomBooks.toTypedArray()
            BooksColumn(bookList = booksArray)
        }
    }
}

