package com.flexcode.roomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Integrate with entity
@Entity(tableName = "user_table")
//data class
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val FirstName: String,
    val lastName: String,
    val age: Int
)