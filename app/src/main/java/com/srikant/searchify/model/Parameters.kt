package com.srikant.searchify.model

data class Parameters(
    val country: String,
    val language: String,
    val num: Int,
    val q: String,
    val start: Int
)