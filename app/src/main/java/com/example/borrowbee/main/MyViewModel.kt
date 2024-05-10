package com.example.borrowbee.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.borrowbee.R
import com.example.borrowbee.data.entities.BookEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {
    private val _roomBooks = MutableStateFlow<List<BookEntity>>(emptyList())
    val roomBooks: StateFlow<List<BookEntity>> = _roomBooks

    private val bookDao = MainApplication.localDatabase.bookDao()
    private val database = MainApplication.localDatabase

    fun fetchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val booksFromDatabase = bookDao.getBestSellers()

            _roomBooks.value = booksFromDatabase
        }
    }


    fun deleatAllBooks(){
        viewModelScope.launch(Dispatchers.IO) {
            val deleteAllBooks = bookDao.deleteAllBooks()
        }

    }


    fun fetchBestSellers() {
        viewModelScope.launch(Dispatchers.IO) {
            val booksFromDatabase = bookDao.getAllBooks()

            _roomBooks.value = booksFromDatabase
        }
    }

    fun InsertAllBooks(){
        viewModelScope.launch(Dispatchers.IO) {


            val books = listOf(
                BookEntity(
                    isbn13= 9780310766926,
                    title = "No place like here",
                    author = "Christina June",
                    bookImage =  R.drawable.book_no_place_like_here,
                    backgroundColor ="#A66BA2",
                    bookProgress = 0f,
                    isBestseller = true),
                BookEntity(
                    isbn13 = 9780812416800,
                    title = "To Kill a Mockingbird",
                    author = "Harper Lee",
                    bookImage =  R.drawable.book_to_kill_a_mocking_bird,
                    backgroundColor ="#57503D",
                    bookProgress = 0f,
                    isBestseller = false),
                BookEntity(
                    isbn13 = 9781784162122,
                    title = "The Book Thief",
                    author = "Markus Zusak",
                    bookImage =  R.drawable.book_the_book_thief,
                    backgroundColor ="#83631F",
                    bookProgress = 0f,
                    isBestseller = true),
                BookEntity(
                    isbn13 = 9781667878232,
                    title = " Beyond Beyond Order or Maps of Meaning by Immersion",
                    author = "Jordan B",
                    bookImage =  R.drawable.book_boss_of_the_body,
                    backgroundColor ="#83631F",
                    bookProgress = 0f,
                    isBestseller = true
                )
            )

            bookDao.insertBooks(books)

            /*books.forEach { book ->
                val existingCount = bookDao.countBooksByTitleAndAuthor(book.title, book.author)
                if (existingCount == 0) {
                    bookDao.insertBooks(book)
                }
            }*/

        }

    }


}

