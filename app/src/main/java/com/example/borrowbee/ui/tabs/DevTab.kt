package com.example.borrowbee.ui.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.borrowbee.main.MyViewModel

@Composable
fun DevTab(){
    TabWithTextFieldAndButton()

}

@Composable
fun TabWithTextFieldAndButton() {
    val viewModel: MyViewModel = viewModel()

    // State to hold the text value
    val (textValue, setTextValue) = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // Text field
        OutlinedTextField(
            value = textValue,
            onValueChange = { setTextValue(it) },
            label = { Text("Enter a string") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Button
        Button(
            onClick = {
                    viewModel.insertBookFromIsbn(textValue.text)
            },
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Text("Button")
        }
    }
}
