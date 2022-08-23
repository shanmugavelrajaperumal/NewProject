package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.myapplication.ItemList
import kotlinx.coroutines.Dispatchers

class MainViewModel constructor(private val repository: MainRepository, application: Application) :
    AndroidViewModel(application) {

    var songList = MutableLiveData<ItemList>()
    val errorMessage = MutableLiveData<String>()

    init {
        getAllPep()
    }

    fun getAllPep() = liveData(Dispatchers.IO) {
        val response = repository.getAll()
        emit(response)
    }

}

