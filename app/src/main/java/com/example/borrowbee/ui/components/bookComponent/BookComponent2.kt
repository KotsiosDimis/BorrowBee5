
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.example.borrowbee.R
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.ui.tabs.fixUrl
import com.example.borrowbee.ui.tabs.openBookDetailsActivity2

@ExperimentalCoilApi
@Composable
fun BookComponent2(book: Book) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(140.dp)
            .padding(8.dp)
            .clickable { openBookDetailsActivity2(context, book) }

    ) {




        BookImage(book.imageUrl,book)


        Spacer(modifier = Modifier.height(4.dp))

        // Title
        Text(
            text = book.title,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Author
        Text(
            text = book.author,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Additional details (publisher, publication date, etc.) can be added here if needed
    }
}


@Composable
fun BookImage(imageUrl: String?,book: Book){
    AsyncImage(

        model = fixUrl(imageUrl), // fixUrls fixes http to https
        placeholder = painterResource(id = R.drawable.book_boss_of_the_body),
        error = painterResource(id = R.drawable.book_eat_better),
        contentDescription = book.title,
        modifier = Modifier
            .height(180.dp)
            .width(140.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.FillHeight,

    )
}

