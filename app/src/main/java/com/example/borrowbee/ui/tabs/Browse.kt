package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.borrowbee.R
import com.example.borrowbee.data.models.BookGenreModel
import com.example.borrowbee.data.repos.BooksRepository
import com.example.borrowbee.ui.components.SearchBar.TopSearchBar
import com.example.borrowbee.ui.theme.robotoCondenseFamily


@Composable
fun BrowseTab() {
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
            TopSearchBar()
            Spacer(modifier = Modifier.height(12.dp))
            BookGenreGrid(bookGenreModelList = BooksRepository.getGenres())
        }
    }
}

@Composable
fun BrowseToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 6.dp),
    ) {

        var searchValue by remember { mutableStateOf("Search books, authors or genres") }
        TextField(
            value = searchValue,
            onValueChange = { searchValue = it },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape
                ),
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_search), null, tint = Color.White) },
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.ic_filter), null, tint = Color.White,modifier = Modifier.size(22.dp)) }
        )

    }

}


@Composable
fun BookGenreGrid(bookGenreModelList: ArrayList<BookGenreModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        items(bookGenreModelList.windowed(2, 2, true)) { subList ->
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                subList.forEach { genre ->
                    BookGenreItem(genre)
                }
            }
            Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())
        }

        // Avoid over-lapping with bottom navigation bar
        item {
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
fun BookGenreItem(genre: BookGenreModel) {
    Box(modifier = Modifier
        .height(230.dp)
        .width(145.dp)
        .clickable {}
        .background(
            color = genre.backgroundColor,
            shape = RoundedCornerShape(8.dp)
        ),


    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                genre.name,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            Image(
                painter = painterResource(id = genre.bookImage),
                null,
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth(0.60f),
                contentScale = ContentScale.Inside
            )
        }

    }
}

