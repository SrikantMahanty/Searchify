package com.srikant.searchify.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.srikant.searchify.utils.Constant.Companion.BASE_URL

object RetrofitInstnace {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: WebSearchApi by lazy {
        retrofit.create(WebSearchApi::class.java)
    }
}