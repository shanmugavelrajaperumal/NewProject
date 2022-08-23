package com.example.myapplication.service

import com.example.myapplication.ItemList

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET

interface RetrofitService {

    @GET("api/v1/people")
    suspend fun getAllPeople(): ItemList

    @GET("api/v1/rooms")
    suspend fun getAllRooms(): ItemList

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://61e947967bc0550017bc61bf.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)

            }
            return retrofitService!!
        }
    }
}



