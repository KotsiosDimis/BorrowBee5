package com.example.borrowbee.data.entities


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "book")
data class  Book (
    @PrimaryKey(autoGenerate = false)
    val isbn13: String,
    val title: String,
    val author: String,
    val publisher: String,
    val publicationDate: String,
    val imageUrl: String?
) : Parcelable {

}