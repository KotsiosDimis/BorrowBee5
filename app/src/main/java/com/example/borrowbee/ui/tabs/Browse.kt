package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.borrowbee.R
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
            //BookGenreGrid(bookGenreModelList = BooksRepository.getGenres())
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




