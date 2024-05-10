package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.ui.theme.robotoCondenseFamily

@Composable
fun FavouritesTab() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background),
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                vertical = 8.dp,
                horizontal = 12.dp)
        ) {
            //items(BooksRepository.favourites) { book ->
                //FavouriteItem(context = context, bookModel = book)
            //}

            // Avoid over-lapping with bottom navigation bar
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
fun FavouriteItem(bookEntity: BookEntity) {
    val context = LocalContext.current
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            openBookDetailsActivity(context, bookEntity, true)
        }
    ) {
        Image(
            painter = painterResource(id = bookEntity.bookImage),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier.width(140.dp)
        )

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                bookEntity.title,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 21.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                bookEntity.author,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(4.dp))

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}