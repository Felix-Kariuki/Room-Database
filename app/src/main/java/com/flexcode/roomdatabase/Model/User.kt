package com.flexcode.roomdatabase.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Parcelize anotation
@Parcelize
//Integrate with entity
@Entity(tableName = "user_table")
//data class
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val FirstName: String,
    val lastName: String,
    val age: Int
): Parcelable