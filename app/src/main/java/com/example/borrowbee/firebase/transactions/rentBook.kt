package com.example.borrowbee.firebase.transactions

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Calendar

// Function to record a book rental transaction in Firestore
fun rentBook(bookId: Long) {
    val db = FirebaseFirestore.getInstance()

    // Create a new transaction document
    val transactionData = hashMapOf(
        "book_isbn" to bookId,
        "transactionType" to "rental",
        "timestamp" to Calendar.getInstance().time
        // Add any other relevant data to the transaction document
    )

    // Add the transaction document to the Firestore collection
    db.collection("books_transactions")
        .add(transactionData)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}
