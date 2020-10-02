package com.naat.kotlin102.network

import retrofit2.Response
import retrofit2.http.GET

interface Endpoints {
    @GET("available_books/")
    suspend fun books(): Response<BookResponse>
}