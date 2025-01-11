package com.srikant.searchify.model

data class WebSearch(
    val `data`: List<Data>,
    val parameters: Parameters,
    val request_id: String,
    val status: String
)