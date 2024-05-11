package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.borrowbee.R
import com.example.borrowbee.main.MainApplication
import com.example.borrowbee.main.MyViewModel
import com.example.borrowbee.ui.theme.robotoCondenseFamily


const val key_book = "key_book"
const val key_is_bookmarked = "key_is_bookmarked"
const val key_author = "key_author"

const val key_book2 = "key_book2"

@Composable
fun HomeTab() {
    val context = LocalContext.current

    val viewModel: MyViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.deleatAllBooks()
        viewModel.insertAllBooks()
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background),
    ) {

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                MyBooks()
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                BestSellers()
            }
        }

        // Avoid over-lapping with bottom navigation bar
        item {
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}

@Composable
fun Heading(id : Int) {
    Spacer(modifier = Modifier.height(22.dp))
    Text(
        text = stringResource(id = id),
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 28.sp,
        fontFamily = robotoCondenseFamily,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 4.dp),
    )
    Spacer(modifier = Modifier.height(12.dp))
}


@Composable
fun BestSellers() {
    Heading(id = R.string.best_sellers)

    val viewModel: MyViewModel = viewModel()

    val bestSellers by viewModel.roomBooks.collectAsState()

    LaunchedEffect(Unit) {
        // Fetch books using the view model
        viewModel.fetchBestSellers()
    }

    val bestSellerBooks = bestSellers.toTypedArray()

    BooksList(bookList =  bestSellerBooks)
}



@Composable
fun MyBooks() {

    Heading(id = R.string.my_books)

    val bookDao = MainApplication.localDatabase.bookDao()

    val viewModel: MyViewModel = viewModel()

    // Observe changes in the roomBooks list and update the local state accordingly
    val MyBooks by viewModel.roomBooks.collectAsState()

    // Trigger fetching books from the database when HomeTab composable is initially composed
    LaunchedEffect(Unit) {
        // Fetch books using the view model
        viewModel.fetchBooks()
        viewModel.insertBookFromIsbn("9780062882776")
    }

    // Convert the list of BookModel to Array
    val booksArray = MyBooks.toTypedArray()

    // Pass the list of books to MyBooksList composable
    BooksList(bookList = booksArray)

}




