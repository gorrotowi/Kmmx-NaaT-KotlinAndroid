package com.naat.kotlin102.repo

import com.naat.kotlin102.SimpleBook
import com.naat.kotlin102.network.Api
import com.naat.kotlin102.network.PayloadItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepo {

    val api = Api()

    suspend fun getBooks() = withContext(Dispatchers.Default) {
        val result = api.getBooks()
        val listBooks = result?.payload?.map { item ->
            item?.toSimpleBook()
        }
        return@withContext listBooks
    }

    fun PayloadItem.toSimpleBook(): SimpleBook {
        return SimpleBook(
            bookName = this.book ?: "",
            maxPrice = maximumPrice ?: ""
        )
    }

}