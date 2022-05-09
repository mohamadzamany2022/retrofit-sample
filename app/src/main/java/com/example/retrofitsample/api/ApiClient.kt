package com.example.retrofitsample.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }
    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService :  ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }

}