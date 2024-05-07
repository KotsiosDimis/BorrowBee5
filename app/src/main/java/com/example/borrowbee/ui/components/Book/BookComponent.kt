package com.example.borrowbee.ui.components.Book

import android.content.Context
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.borrowbee.R
import com.example.borrowbee.data.models.BookModel
import com.example.borrowbee.ui.tabs.openBookDetailsActivity
import com.example.borrowbee.ui.theme.robotoCondenseFamily

@Composable
fun BookComponent(bookModel: BookModel, context: Context) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentHeight()
            .padding(8.dp)
            .clickable { openBookDetailsActivity(context, bookModel) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = bookModel.bookImage),
            null,
            modifier = Modifier
                .height(200.dp)
                .width(170.dp),
            contentScale = ContentScale.Inside
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            bookModel.title,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            maxLines = 3,
            textAlign = TextAlign.Center
        )

        Text(
            bookModel.author,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
    }
}

@Composable
fun MyBookItem(bookModel: BookModel, context: Context) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(140.dp)
            .padding(8.dp)
            .clickable { openBookDetailsActivity(context, bookModel) }
    ) {
        Image(
            painter = painterResource(id = bookModel.bookImage),
            null,
            modifier = Modifier
                .height(180.dp)
                .width(140.dp),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            bookModel.title,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            bookModel.author,
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
            LinearProgressIndicator(
                //progress = book.bookProgress,
                modifier = Modifier.width(5.dp),
                color = colorResource(id = R.color.progress_color),
                trackColor = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                "${(bookModel.bookProgress * 5).toInt()}%",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 13.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.Light
            )
        }

    }
}
