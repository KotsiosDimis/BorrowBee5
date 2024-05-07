package com.example.borrowbee.ui.tabs

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.borrowbee.R
import com.example.borrowbee.activities.BookDetailActivity
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.models.BookModel
import com.example.borrowbee.data.repos.BooksRepository.Companion.getBestSellers
import com.example.borrowbee.ui.components.Book.BookComponent
import com.example.borrowbee.ui.components.Book.MyBookItem
import com.example.borrowbee.ui.components.SearchBar.TopSearchBar
import com.example.borrowbee.ui.theme.robotoCondenseFamily


const val key_book = "key_book"
const val key_is_bookmarked = "key_is_bookmarked"

@Composable
fun HomeTab(context: Context) {

    var backgroundColor by remember { mutableStateOf(Color.White) }

    @Composable
    fun changeBackgroundColor() {
        backgroundColor = if (backgroundColor == Color.White) {
            MaterialTheme.colorScheme.background // Use the background color from the Material U theme
        } else {
            Color.White
        }
    }



    val bestSellerBooks = remember { getBestSellers() }


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background),
    ) {

        item {
            TopSearchBar()
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                MyBooks(context)
            }
        }

        item {
            Text(
                context.getString(R.string.best_sellers),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 28.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 8.dp),
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        items(bestSellerBooks.windowed(2, 2, true)) { subList ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                subList.forEach { book ->
                    BookComponent(bookModel = book, context = context)
                }
            }
        }

        // Avoid over-lapping with bottom navigation bar
        item {
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}


@Composable
fun MyBooks(context: Context) {
    //val db = Firebase.firestore

    Spacer(modifier = Modifier.height(22.dp))
    Text(
        context.getString(R.string.my_books),
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 28.sp,
        fontFamily = robotoCondenseFamily,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 4.dp),
    )
    Spacer(modifier = Modifier.height(12.dp))

    //MyBooksList(bookList = BookRepository.getAllBooks(), context)

   // MyBooksList3(bookList = getMyBooks(), context)


}
@Composable
fun MyBooksList3(bookList: List<BookEntity>, context: Context) {
    LazyRow {
        items(bookList) { book ->
            MyBookItem(bookEntity = book, context = context)
        }
    }
}


@Composable
fun MyBooksList(bookList: ArrayList<BookModel>, context: Context) {
    LazyRow {
        items(bookList) { book ->
            MyBookItem(bookModel = book, context = context)
        }
    }
}







fun openBookDetailsActivity(context: Context, bookModel: BookModel, isBookmarked: Boolean = false) {
    val intent = Intent(context, BookDetailActivity::class.java).apply {
        putExtra(key_book, bookModel)
        putExtra(key_is_bookmarked, isBookmarked)
    }
    context.startActivity(intent)
}