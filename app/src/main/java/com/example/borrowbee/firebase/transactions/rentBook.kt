package com.example.borrowbee.firebase.transactions

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Calendar

private const val TAG = "RentBookFunction"

fun rentBook(
    bookId: String,
    rentedDate: String,
    returnedDate: String,
    transactionType: String,
    userId: String
) {
    val db = FirebaseFirestore.getInstance()


    // Create a new transaction document
    val transactionData = hashMapOf(
        "bookId" to bookId,
        "rentedDate" to rentedDate,
        "returnedDate" to returnedDate,
        "transactionType" to transactionType,
        "userId" to userId,
        "timestamp" to Calendar.getInstance().time
        // Add any other relevant data to the transaction document
    )

    // Add the transaction document to the Firestore collection
    db.collection("books_transactions")
        .add(transactionData)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            println("DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
            println("DocumentSnapshot failed ")
        }
}
