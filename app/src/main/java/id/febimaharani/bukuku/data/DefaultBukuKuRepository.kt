package id.febimaharani.bukuku.data

import id.febimaharani.bukuku.model.Book
import id.febimaharani.bukuku.network.BukuKuApiService

// implementasi repository default volume data dari sumber data (network)
class DefaultBukuKuRepository(
    private val bukuKuApiService: BukuKuApiService
) : BukuKuRepository {
    // Mengambil daftar buku dari sumber data (network) 
    override suspend fun getBooks(query: String): List<Book>? {
        return try {
            val res = bukuKuApiService.getBooks(query)
            if (res.isSuccessful) {
                res.body()?.items ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getBook(id: String): Book? {
        return try {
            val res = bukuKuApiService.getBook(id)
            if (res.isSuccessful) {
                res.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
