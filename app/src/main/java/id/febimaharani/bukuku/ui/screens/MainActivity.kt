package id.febimaharani.bukuku.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.febimaharani.bukuku.ui.BukuKuApp
import id.febimaharani.bukuku.ui.theme.BukuKuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BukuKuTheme() {
                BukuKuApp()
            }
        }
    }
}
