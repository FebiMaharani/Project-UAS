package id.febimaharani.bukuku.di

import id.febimaharani.bukuku.data.BukuKuRepository
import id.febimaharani.bukuku.data.DefaultBukuKuRepository
import id.febimaharani.bukuku.network.BukuKuApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DefaultAppContainer : AppContainer {

    override val bukuKuApiService: BukuKuApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BukuKuApiService.BASE_URL)
            .build()
            .create()
    }

    override val bukukuRepository: BukuKuRepository by lazy {
        DefaultBukuKuRepository(bukuKuApiService)
    }
}