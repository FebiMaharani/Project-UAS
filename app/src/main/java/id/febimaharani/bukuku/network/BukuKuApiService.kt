package id.febimaharani.bukuku.network

import id.febimaharani.bukuku.model.Book
import id.febimaharani.bukuku.model.QueryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Interface public mendefinisikan layanan API menggunakan retrofit
// Interface ini mmenyediakan metode untuk mwngambil data buku dari API
interface BukuKuApiService {

    // TODO : BASE_URL mendefinisikan URL dasar API Google Books
    companion object {
        const val BASE_URL = "https://www.googleapis.com/books/v1/"
    }

    // TODO : mendapatkan daftar buku dari query pencarian
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<QueryResponse>

    // TODO : Fungsi untuk mendapatkan detail buku
    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): Response<Book>
}
