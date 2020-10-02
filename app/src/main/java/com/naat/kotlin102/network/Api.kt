package com.naat.kotlin102.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.create

class Api {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.bitso.com/v3/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    suspend fun getBooks(): BookResponse? = withContext(Dispatchers.IO) {
        val bookEndpoint = retrofit.create<Endpoints>()
        val response = bookEndpoint.books()
        return@withContext if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

}