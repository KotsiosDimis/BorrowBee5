package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartTab() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 12.dp,
                end = 12.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Insert Book",
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Input fields for book information
            // You can replace these Text fields with appropriate input fields like TextField
            Text("Title:")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Author:")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Genre:")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Book Image:")
            Spacer(modifier = Modifier.height(4.dp))
            Text("Background Color:")
            Spacer(modifier = Modifier.height(16.dp))
            // Button to insert book
            // You can replace this with a Button composable and add logic to insert the book
            Text("Insert Book")
        }
    }
}

