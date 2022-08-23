package com.example.myapplication.viewmodel

import com.example.myapplication.service.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAll() = retrofitService.getAllPeople()
}