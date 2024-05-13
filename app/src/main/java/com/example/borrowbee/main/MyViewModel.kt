package com.example.borrowbee.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.borrowbee.apis.fetchBookDetails
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.data.entities.UserFavoriteBook
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {

    private val _roomBooks = MutableStateFlow<List<Book>>(emptyList())
    val roomBooks: StateFlow<List<Book>> = _roomBooks

    private val _isFavorite = MutableStateFlow<Boolean>(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite


    private val bookDao = MainApplication.localDatabase.bookDao()
    private val rentedBookDao = MainApplication.localDatabase.rentedDao()
    private val favoriteBookDao= MainApplication.localDatabase.favoritesDao()




    fun fetchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val allBooks = bookDao.getAllBooks()

            _roomBooks.value = allBooks
        }
    }

    fun fetchFavoriteBooks(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val favoriteBooks = favoriteBookDao.getFavoriteBooks(userId = 1)

            _roomBooks.value = favoriteBooks
        }
    }

    fun fetchRentedBooks(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
           // val rentedBooks = rentedBookDao.getAllRentedBooks(userId = 1)

        }
    }

    fun isBookFavorite(userId: Int, isbn13: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val isFavorite = true //favoriteBookDao.isBookFavorite(userId, isbn13)

            _isFavorite.value = isFavorite
        }
    }


    fun addToFavUserBooks(userString: Int, isbn13: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val book = UserFavoriteBook(userString, isbn13)
            favoriteBookDao.addUserFavoriteBook(book)
        }
    }

    fun removeToFavUserBooks(userId: Int, isbn13: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val book = UserFavoriteBook(userId, isbn13)
            favoriteBookDao.deleteUserFavoriteBook(book)
        }
    }

    fun insertBookFromIsbn(isbn13: String) {

        viewModelScope.launch(Dispatchers.IO) {
            // Call the fetchBookDetails function to retrieve book data
            val book = fetchBookDetails(isbn13)
          
            // Check if a book was retrieved successfully
            if (book != null) {
                // Call insert1book to insert the retrieved book data
                insert1book(book)



            } else {
                // Handle the case where no book was found for the ISBN-13
                // (e.g., display a message to the user)
            }
        }
    }

    private fun insert1book(book: Book){
        viewModelScope.launch(Dispatchers.IO){

            bookDao.insertBook(book)

        }
    }


}



