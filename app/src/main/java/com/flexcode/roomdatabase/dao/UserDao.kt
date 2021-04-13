package com.flexcode.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.flexcode.roomdatabase.Model.User

//contains methods for accessing database

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user : User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}