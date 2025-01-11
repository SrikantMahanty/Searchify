package com.srikant.searchify.model

data class Data(
    val displayed_link: String,
    val position: Int,
    val rank: Int,
    val snippet: String,
    val source: String,
    val title: String,
    val url: String
)