package id.febimaharani.bukuku.network

import id.febimaharani.bukuku.model.Book
import id.febimaharani.bukuku.model.QueryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * A public interface that exposes the [getBooks] method
 */
interface BukuKuApiService {

    companion object {
        const val BASE_URL = "https://www.googleapis.com/books/v1/"
    }

    /**
     * Returns a [List] of [Book] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "volumes" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<QueryResponse>

    @GET("volumes/{id}")
    suspend fun getBook(@Path("id") id: String): Response<Book>
}