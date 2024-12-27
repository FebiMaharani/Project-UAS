package id.febimaharani.bukuku.ui.screens.query_screen

import id.febimaharani.bukuku.model.Book

sealed interface QueryUiState {
    data class Success(val bukukuList: List<Book>) : QueryUiState
    object Error : QueryUiState
    object Loading : QueryUiState
}