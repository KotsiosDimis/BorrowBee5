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

    fun fetchBestSellers() {
        viewModelScope.launch(Dispatchers.IO) {
            val bestSellers = bookDao.getBestSellers()

            _roomBooks.value = bestSellers
        }
    }

    fun insertAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {


            val books = listOf(
                BookEntity(
                    isbn13 = 9780310766926,
                    title = "No place like here",
                    author = "Christina June",
                    bookImage = R.drawable.book_no_place_like_here,
                    backgroundColor = "#A66BA2",
                    isBestseller = false
                ),
                BookEntity(
                    isbn13 = 9780812416800,
                    title = "To Kill a Mockingbird",
                    author = "Harper Lee",
                    bookImage = R.drawable.book_to_kill_a_mocking_bird,
                    backgroundColor = "#57503D",
                    isBestseller = false
                ),
                BookEntity(
                    isbn13 = 9781784162122,
                    title = "The Book Thief",
                    author = "Markus Zusak",
                    bookImage = R.drawable.book_the_book_thief,
                    backgroundColor = "#83631F",
                    isBestseller = false
                ),
                BookEntity(
                    isbn13 = 9781667878232,
                    title = "To the moon",
                    author = "Max Born",
                    bookImage = R.drawable.book_to_the_moon,
                    backgroundColor = "#36A0B5",
                    isBestseller = true
                ),
                BookEntity(
                    isbn13 = 9781734231274,
                    title = "Secret of the Divine Love",
                    author = "A. Helwa",
                    bookImage = R.drawable.book_secrets_of_divine_love,
                    backgroundColor = "#f07f4a",
                    isBestseller = true
                ),
                BookEntity(9781338878929,"Harry Potter ", "J.K. Rowling", R.drawable.book_harry_porter,"#55368C",true),
                BookEntity(9781472224200,"In a Land of Paper Gods", "Rebecca Mackenzie", R.drawable.book_in_a_land_of_paper_gods, "#145E82",true),
                BookEntity(9780393358490,"Will My Cat Eat My Eyeballs?", "Caitlin Doughty", R.drawable.book_will_my_cat_eat_my_eyeballs, "#CA3F5A",true),
                BookEntity(9780062882776,"Clap When You Land", "Elizabeth Acevedo", R.drawable.book_clap_when_you_can, "#B15236",true),

            )

            bookDao.insertBooks(books)

        }
    }

}

