package id.febimaharani.bukuku.di

import id.febimaharani.bukuku.data.BukuKuRepository
import id.febimaharani.bukuku.network.BukuKuApiService

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val bukuKuApiService: BukuKuApiService
    val bukukuRepository: BukuKuRepository
}