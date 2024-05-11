package com.example.borrowbee.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.borrowbee.R
import com.example.borrowbee.apis.fetchBookDetails
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.entities.UserFavoriteBook
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {
    private val _roomBooks = MutableStateFlow<List<BookEntity>>(emptyList())
    private val _roomBooks2 = MutableStateFlow<List<Book>>(emptyList())
    val roomBooks: StateFlow<List<BookEntity>> = _roomBooks
    val roomBooks2: StateFlow<List<Book>> = _roomBooks2

    private val bookDao = MainApplication.localDatabase.bookDao()
    private val bookDao2 = MainApplication.localDatabase.bookDao2()
    private val rentedBookDao = MainApplication.localDatabase.rentedBookDao()
    private val favoriteBookDao= MainApplication.localDatabase.favoriteBookDao()




    fun deleatAllBooks(){
        viewModelScope.launch(Dispatchers.IO) {
            val deleteAllBooks = bookDao.deleteAllBooks()
        }
    }

    fun fetchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val allBooks = bookDao.getAllBooks()

            _roomBooks.value = allBooks
        }
    }

    fun fetchBooks2() {
        viewModelScope.launch(Dispatchers.IO) {
            val allBooks2 = bookDao2.getAllBooks()

            _roomBooks2.value = allBooks2
        }
    }

    fun fetchBestSellers() {
        viewModelScope.launch(Dispatchers.IO) {
            val bestSellers = bookDao.getBestSellers()

            _roomBooks.value = bestSellers
        }
    }


    fun addToFavUserBooks(userString: Int,isbn13: String){
        viewModelScope.launch(Dispatchers.IO){
            val book = UserFavoriteBook(userString,isbn13)
            favoriteBookDao.addUserFavoriteBook(book)
        }
    }

    fun removeToFavUserBooks(userId: Int,isbn13: String){
        viewModelScope.launch(Dispatchers.IO){
            val book = UserFavoriteBook(userId,isbn13)
            favoriteBookDao.deleteUserFavoriteBook(book)
        }
    }

    fun insertAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            // Lists of books
            val books = listOf(
                BookEntity(9780310766926, "No place like here", "Christina June", bookImage = R.drawable.book_no_place_like_here, backgroundColor = "#A66BA2", isBestseller = false),
                BookEntity(9780812416800, "To Kill a Mockingbird", "Harper Lee", bookImage = R.drawable.book_to_kill_a_mocking_bird, backgroundColor = "#57503D", isBestseller = false),
                BookEntity(9781784162122, "The Book Thief", "Markus Zusak", bookImage = R.drawable.book_the_book_thief, backgroundColor = "#83631F", isBestseller = false),
                BookEntity(9781667878232, "To the moon", "Max Born", bookImage = R.drawable.book_to_the_moon, backgroundColor = "#36A0B5", isBestseller = true),
                BookEntity(781734231274,  "Secret of the Divine Love", author = "A. Helwa", bookImage = R.drawable.book_secrets_of_divine_love, backgroundColor = "#f07f4a", isBestseller = true),
                BookEntity(9781338878929, "Harry Potter ", "J.K. Rowling", R.drawable.book_harry_porter, "#55368C", true),
                BookEntity(9781472224200, "In a Land of Paper Gods", "Rebecca Mackenzie", R.drawable.book_in_a_land_of_paper_gods, "#145E82", true),
                BookEntity(9780393358490, "Will My Cat Eat My Eyeballs?", "Caitlin Doughty", R.drawable.book_will_my_cat_eat_my_eyeballs, "#CA3F5A", true),
                BookEntity(9780062882776, "Clap When You Land", "Elizabeth Acevedo", R.drawable.book_clap_when_you_can, "#B15236", true),
                )
            bookDao.insertBooks(books)
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

    fun insert1book(book: Book){
        viewModelScope.launch(Dispatchers.IO){

            bookDao2.insertBook(book)

        }
    }


}

