package id.febimaharani.bukuku.data

import id.febimaharani.bukuku.model.Book

// Repository
interface BukuKuRepository {
    // mengambil data buku dari url network
    suspend fun getBooks(query: String): List<Book>?

    suspend fun getBook(id: String): Book?
}
