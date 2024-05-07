package com.example.borrowbee.activities

import com.example.borrowbee.data.entities.BookEntity

data class TestBooksData(
    val books: List<BookEntity> = listOf(
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
)
