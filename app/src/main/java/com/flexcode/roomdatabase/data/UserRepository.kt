package com.flexcode.roomdatabase.data

import androidx.lifecycle.LiveData
import com.flexcode.roomdatabase.Dao.UserDao


//its a class abstract access to multiple data sources
class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}