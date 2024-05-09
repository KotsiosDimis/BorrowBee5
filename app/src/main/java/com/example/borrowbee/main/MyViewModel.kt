package com.example.borrowbee.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.borrowbee.data.entities.BookEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {
    private val _roomBooks = MutableStateFlow<List<BookEntity>>(emptyList())
    val roomBooks: StateFlow<List<BookEntity>> = _roomBooks

    private val bookDao = MainApplication.localDatabase.bookDao()

    fun fetchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val booksFromDatabase = bookDao.getAllBooks()

            _roomBooks.value = booksFromDatabase
        }
    }


    fun fetchBestSellers() {
        viewModelScope.launch(Dispatchers.IO) {
            val booksFromDatabase = bookDao.getAllBooks()

            _roomBooks.value = booksFromDatabase
        }
    }
}

