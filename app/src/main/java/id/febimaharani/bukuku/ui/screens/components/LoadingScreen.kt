package id.febimaharani.bukuku.ui.screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.febimaharani.bukuku.ui.theme.BukuKuTheme

// menampilkan loading dengan indikator progres
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}


@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    BukuKuTheme() {
        LoadingScreen()
    }
}
