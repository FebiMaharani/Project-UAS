package id.febimaharani.bukuku

import android.app.Application
import id.febimaharani.bukuku.di.AppContainer
import id.febimaharani.bukuku.di.DefaultAppContainer

class BukuKuApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}