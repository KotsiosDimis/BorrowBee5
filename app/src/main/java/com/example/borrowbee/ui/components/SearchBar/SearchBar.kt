@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.borrowbee.ui.components.SearchBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun TopSearchBar() {
    var text by remember { mutableStateOf( "")}
    var active by remember { mutableStateOf( false)}
    var items = remember {
        mutableListOf(
            "Bible",
            "harry poter"
        )
    }
        Surface(
            modifier = Modifier.fillMaxWidth(),  /// itan max size
            color = MaterialTheme.colorScheme.background
        ) {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = text,
                onQueryChange = {
                    text = it
                } ,
                onSearch = {
                    items.add(text)
                    active = false
                    text = ""
                },
                active = active,
                onActiveChange ={
                    active = it
                },
                placeholder = {
                    Text(text = "Search ")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if(active) {
                        Icon(
                            modifier = Modifier.clickable{
                                if(text.isNotEmpty()){
                                    text = ""
                                } else{
                                    active = false
                                }

                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon")
                    }
                }
            ) { items.forEach{
                Row(modifier = Modifier.padding(all = 14.dp)){
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "History icon",
                        modifier = Modifier.padding(end = 10.dp),

                        )
                    Text(text = it)
                }

            }

        }

        }

}
