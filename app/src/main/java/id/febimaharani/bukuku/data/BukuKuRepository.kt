package id.febimaharani.bukuku.data

import id.febimaharani.bukuku.model.Book

/**
 * Repository retrieves volume data from underlying data source.
 */
interface BukuKuRepository {
    /** Retrieves list of books from underlying data source */
    // Notes: List<Book>? NULLABLE
    suspend fun getBooks(query: String): List<Book>?

    suspend fun getBook(id: String): Book?
}