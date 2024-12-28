package id.febimaharani.bukuku.di

import id.febimaharani.bukuku.data.BukuKuRepository
import id.febimaharani.bukuku.network.BukuKuApiService

// TODO sebagai kontainer Dependency Injection (Di) aplikasi  
// kontainer Dependency Injection aplikasi
interface AppContainer {
    // TODO menyediakan instance dari BukuKuApiService
    val bukuKuApiService: BukuKuApiService
    // TODO menyediakan instance dari BukuKuRepository
    val bukukuRepository: BukuKuRepository
}
