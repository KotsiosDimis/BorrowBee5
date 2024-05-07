package com.example.borrowbee.ui.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.borrowbee.R


sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : BottomNavigationScreens("Home", R.string.home, Icons.Filled.Home)
    object Browse : BottomNavigationScreens("Browse", R.string.browse, Icons.Filled.Search)
    object Favourites : BottomNavigationScreens("Bookmark", R.string.favourites, Icons.Filled.Bookmark)
    object Cart : BottomNavigationScreens("Cart", R.string.cart, Icons.Filled.ShoppingCart)
}