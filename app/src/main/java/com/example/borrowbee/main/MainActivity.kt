package com.example.borrowbee.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.borrowbee.data.daos.BookDao
import com.example.borrowbee.ui.components.navigation.BottomNavigation
import com.example.borrowbee.ui.components.navigation.BottomNavigationScreens
import com.example.borrowbee.ui.tabs.BrowseTab
import com.example.borrowbee.ui.tabs.CartTab
import com.example.borrowbee.ui.tabs.DevTab
import com.example.borrowbee.ui.tabs.FavouritesTab
import com.example.borrowbee.ui.tabs.HomeTab
import com.example.borrowbee.ui.theme.BorrowBeeTheme


class MainActivity : AppCompatActivity() {
    private lateinit var bookDao: BookDao



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            BorrowBeeTheme {
                MainScreen()


            }
        }
    }


    @Composable
    private fun MainScreenNavigationConfigurations(
        navController: NavHostController
    ) {
        NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
            composable(BottomNavigationScreens.Home.route) {
                HomeTab()
            }
            composable(BottomNavigationScreens.Browse.route) {
                BrowseTab()
            }
            composable(BottomNavigationScreens.Favourites.route) {
                FavouritesTab()
            }
            composable(BottomNavigationScreens.Cart.route) {
                CartTab()
            }
            composable(BottomNavigationScreens.DevTab.route) {
                DevTab()
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    @Preview
    fun MainScreen() {
        val navController = rememberNavController()
        val bottomNavigationItems = listOf(
            BottomNavigationScreens.Home,
            BottomNavigationScreens.Browse,
            BottomNavigationScreens.Favourites,
            BottomNavigationScreens.Cart,
            BottomNavigationScreens.DevTab,
        )

        Scaffold(
            bottomBar = {
                BottomNavigation(navController, bottomNavigationItems)
            }
        ) {
            MainScreenNavigationConfigurations(navController)
        }
    }

}