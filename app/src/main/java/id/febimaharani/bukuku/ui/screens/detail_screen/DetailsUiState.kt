package id.febimaharani.bukuku.ui.screens.detail_screen

import id.febimaharani.bukuku.model.Book

// menampilkan setail status ui (loading, eror, menyimpan buku)
sealed interface DetailsUiState {
    data class Success(val bookItem: Book) : DetailsUiState
    object Error : DetailsUiState
    object Loading : DetailsUiState
}
