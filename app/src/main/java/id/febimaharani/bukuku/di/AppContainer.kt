package id.febimaharani.bukuku.di

import id.febimaharani.bukuku.data.BukuKuRepository
import id.febimaharani.bukuku.network.BukuKuApiService

// kontainer Dependency Injection aplikasi
interface AppContainer {
    val bukuKuApiService: BukuKuApiService
    val bukukuRepository: BukuKuRepository
}
