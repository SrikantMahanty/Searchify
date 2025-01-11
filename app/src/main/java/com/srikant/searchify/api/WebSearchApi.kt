package com.srikant.searchify.api

import com.srikant.searchify.model.WebSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WebSearchApi {

    @Headers(
        "x-rapidapi-host: real-time-web-search.p.rapidapi.com",
        "x-rapidapi-key: 3408cfa745msh47b2100936249c9p1f7006jsn919d88bb65cc"
    )
    @GET("search-advanced") // Updated endpoint
    suspend fun getWebSearch(
        @Query("q") query: String,
        @Query("num") numResults: Int, // Changed from pageNumber to num
        @Query("start") start: Int, // Changed from pageSize to start
        @Query("gl") gl: String, // Added new query param
        @Query("hl") hl: String  // Added new query param
    ): Response<WebSearch>
}
