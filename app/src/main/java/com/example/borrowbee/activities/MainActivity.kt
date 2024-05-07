package com.example.borrowbee.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.borrowbee.data.database.AppDatabase
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.repos.BookRepository
import com.example.borrowbee.ui.components.BottomNavigation.BottomNavigation
import com.example.borrowbee.ui.screens.BottomNavigationScreens
import com.example.borrowbee.ui.tabs.BrowseTab
import com.example.borrowbee.ui.tabs.CartTab
import com.example.borrowbee.ui.tabs.FavouritesTab
import com.example.borrowbee.ui.tabs.HomeTab
import com.example.borrowbee.ui.theme.BorrowBeeTheme
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var database: RoomDatabase
    }

    private lateinit var bookRepository: BookRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Room database and repository
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "my_database"
        ).build()



        bookRepository = BookRepository(database.bookDao())

        // Insert test books into the database
        insertTestBooks()

        setContent {
            BorrowBeeTheme {
                MainScreen()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Close Room database
        AppDatabase.getInstance(this).close()
    }



    @Composable
    private fun MainScreenNavigationConfigurations(
        navController: NavHostController
    ) {
        NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
            composable(BottomNavigationScreens.Home.route) {
                HomeTab(this@MainActivity)
            }
            composable(BottomNavigationScreens.Browse.route) {
                BrowseTab()
            }
            composable(BottomNavigationScreens.Favourites.route) {
                FavouritesTab(this@MainActivity)
            }
            composable(BottomNavigationScreens.Cart.route) {
                CartTab()
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
        )

        Scaffold(
            bottomBar = {
                BottomNavigation(navController, bottomNavigationItems)
            }
        ) {
            MainScreenNavigationConfigurations(navController)
        }
    }


    private fun insertTestBooks() {
        val testBooks = listOf(
            BookEntity(
                title = "To the Moon",
                author = "Max Born",
                bookProgress = 0.2f,
                isBestseller = true
            ),
            BookEntity(
                title = "Secret of the Divine Love",
                author = "A. Helwa",
                bookProgress = 0.5f,
                isBestseller = false
            ),
            BookEntity(
                title = "Harry Potter",
                author = "J.K. Rowling",
                bookProgress = 0.8f,
                isBestseller = true
            ),
            BookEntity(
                title = "In a Land of Paper Gods",
                author = "Rebecca Mackenzie",
                bookProgress = 0.3f,
                isBestseller = false
            ),
            BookEntity(
                title = "Will My Cat Eat My Eyeballs?",
                author = "Caitlin Doughty",
                bookProgress = 0.6f,
                isBestseller = true
            ),
            BookEntity(
                title = "Clap When You Land",
                author = "Elizabeth Acevedo",
                bookProgress = 0.9f,
                isBestseller = false
            )
        )
        // Insert test books into the database
        lifecycleScope.launch {
            bookRepository.insertBooks(testBooks)
        }
    }

    fun InitialiseDatabace(){
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "my_database"
        ).build()
    }

}