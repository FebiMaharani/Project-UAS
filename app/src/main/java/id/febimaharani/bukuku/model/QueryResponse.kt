package id.febimaharani.bukuku.model

import kotlinx.serialization.Serializable

// data class QueryResponse digunakan untuk menampilkan hasil pencarian dari API 
@Serializable
data class QueryResponse(
    val items: List<Book>?,
    val totalItems: Int,
    val kind: String,
)
