package com.example.borrowbee.data.repos

import androidx.compose.ui.graphics.Color
import com.example.borrowbee.R
import com.example.borrowbee.data.models.BookGenreModel
import com.example.borrowbee.data.models.BookModel


class BooksRepository {
    companion object {
       // val favourites = arrayListOf<BookEntity>()

        val favourites = getBestSellers()


        //val books get() = getMyBooks()



        fun getMyBooks(): ArrayList<BookModel> {
            //return BookDao.getAllBooks()

            return arrayListOf(
                BookModel("No place like here", "Christina June", R.drawable.book_no_place_like_here, "#A66BA2", bookProgress = 10f),
                BookModel("To Kill a Mockingbird", "Harper Lee", R.drawable.book_to_kill_a_mocking_bird, "#57503D",  bookProgress = 5f),
                BookModel("The Book Thief", "Markus Zusak", R.drawable.book_the_book_thief, "#83631F",  bookProgress = 16f),

            )
        }




        fun getBestSellers(): ArrayList<BookModel> {
            return arrayListOf(
                BookModel("To the moon", "Max Born", R.drawable.book_to_the_moon, "#36A0B5"),
                BookModel("Secret of the Divine Love", "A. Helwa", R.drawable.book_secrets_of_divine_love, "#f07f4a"),
                BookModel("Harry Potter ", "J.K. Rowling", R.drawable.book_harry_porter,"#55368C"),
                BookModel("In a Land of Paper Gods", "Rebecca Mackenzie", R.drawable.book_in_a_land_of_paper_gods, "#145E82"),
                BookModel("Will My Cat Eat", "Caitlin Doughty", R.drawable.book_will_my_cat_eat_my_eyeballs, "#CA3F5A"),
                BookModel("Clap When You Land", "Elizabeth Acevedo", R.drawable.book_clap_when_you_can, "#B15236"),
            )
        }

        fun getGenres(): ArrayList<BookGenreModel> {
            return arrayListOf(
                BookGenreModel("Biography", Color(0xFFB7143C), R.drawable.book_the_reign_of_victoria),
                BookGenreModel("Business", Color(0xFF0E6A500), R.drawable.book_tribe_of_mentors),
                BookGenreModel("Children", Color(0xFFEF4C45), R.drawable.book_boss_of_the_body),
                BookGenreModel("Cookery", Color(0xFFF46217), R.drawable.book_eat_better),
                BookGenreModel("Fiction", Color(0xFF009ADE2), R.drawable.book_lost_in_the_never_woods),
                BookGenreModel("Novels", Color(0xFFD36A43), R.drawable.book_how_novels_think),
            )
        }
    }



}

