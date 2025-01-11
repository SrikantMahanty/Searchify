package com.srikant.searchify.repository

import com.srikant.searchify.api.RetrofitInstnace
import com.srikant.searchify.model.WebSearch
import retrofit2.Response

class Repository {
    suspend fun getWebSearch(
        query: String,
        pageNumber: Int,
        pageSize: Int,
        autoCorrect: String,
        h1:String
    ): Response<WebSearch> {
        return RetrofitInstnace.api.getWebSearch(query,pageNumber,pageSize,autoCorrect,h1)
    }
}