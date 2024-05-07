package com.example.borrowbee.data.repos

import com.example.borrowbee.data.daos.BookDao
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.models.BookModel

class BookRepository(private val bookDao: BookDao) {
    suspend fun insert(book: BookEntity) {
        bookDao.insert(book)
    }

    suspend fun getBestSellers(): List<BookEntity> {
        return bookDao.getBestSellers()
    }



    //fun getAllBooks(): List<BookModel> {
   //     return bookDao.getAllBooks2().map { it.toBookModel() }
    //}

    //suspend fun getStoreBook(storeId: Long, bookId: Long): StoreBookEntity? {
     //   return storeBookDao.getStoreBook(storeId, bookId)
    //}

    suspend fun insertBooks(books: List<BookEntity>) {
       bookDao.insertAll(books)
    }

    //fun get1book(): BookModel{
   //     return bookDao.get1book().toBookModel()
    //}



    fun getAllBooks(): ArrayList<BookModel> {
        val bookModels = ArrayList<BookModel>()
        val bookEntities = bookDao.getAllBooks2()
        for (entity in bookEntities) {
            bookModels.add(entity.toBookModel())
        }
        return bookModels
    }

    // Assuming you have a toBookModel extension function in BookEntity
    private fun BookEntity.toBookModel(): BookModel {
        return BookModel(
            title = title,
            author = author,
            bookImage = bookImage,
            backgroundColor = backgroundColor,
            bookProgress = bookProgress
        )
    }
}



