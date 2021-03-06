package com.flexcode.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.flexcode.roomdatabase.dao.UserDao
import com.flexcode.roomdatabase.Model.User


//its a class abstract access to multiple data sources
class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }


}