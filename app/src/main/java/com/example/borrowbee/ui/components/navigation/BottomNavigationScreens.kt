package com.example.borrowbee.ui.components.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.borrowbee.R


sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
      data object Home : BottomNavigationScreens("Home", R.string.home, Icons.Filled.Home)
      data object Browse : BottomNavigationScreens("Browse", R.string.browse, Icons.Filled.Search)
      data object Favourites : BottomNavigationScreens("Bookmark", R.string.favourites, Icons.Filled.Bookmark)
      data object Cart : BottomNavigationScreens("Cart", R.string.cart, Icons.Filled.ShoppingCart)
      data object DevTab : BottomNavigationScreens("DevTab", R.string.DevTab, Icons.Filled.Adb)
}