package com.flexcode.roomdatabase.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.flexcode.roomdatabase.Model.User
import com.flexcode.roomdatabase.data.UserDatabase
import com.flexcode.roomdatabase.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/*To provide data to the ui and survive configuration
* changes. acts as a communication center between the repository
* and the ui*/
class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    //add fun using coroutines viewModelScope IO
    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    //Update user
    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    //delete single user
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    //delete all
    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }
}