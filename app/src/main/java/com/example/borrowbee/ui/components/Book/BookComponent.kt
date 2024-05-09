package com.example.borrowbee.ui.components.Book

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.ui.tabs.openBookDetailsActivity
import com.example.borrowbee.ui.theme.robotoCondenseFamily


@Composable
fun BookComponent(bookEntity: BookEntity) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(140.dp)
            .padding(8.dp)
            .clickable { openBookDetailsActivity(context, bookEntity) }
    ) {
        Image(
            painter = painterResource(id = bookEntity.bookImage),
            contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .width(140.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            bookEntity.title,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            bookEntity.author,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
    }
}
