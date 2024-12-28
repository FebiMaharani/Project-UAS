package id.febimaharani.bukuku.ui.screens.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.febimaharani.bukuku.BukuKuApplication
import id.febimaharani.bukuku.data.BukuKuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

// kelas detail View Model untuk menampilkan detail buku
class DetailsViewModel(
    private val bukukuRepository: BukuKuRepository
): ViewModel() {
    private val _uiStateDetail = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiStateDetail = _uiStateDetail.asStateFlow() 

    fun getBook(id: String) {
        viewModelScope.launch {
            _uiStateDetail.value = try {
                val book = bukukuRepository.getBook(id)
                if (book == null) {
                    DetailsUiState.Error
                } else{
                    DetailsUiState.Success(book)
                }
            } catch (e: IOException) {
                DetailsUiState.Error
            } catch (e: HttpException) {
                DetailsUiState.Error
            }
        }
    }

    // Factory digunakan untuk menginisialisasi viewmodel dengan dependednsi BukuKuRepository
    Factory ini diinisialisasi dengan konteks aplikasi untuk mendapatkan instance BukuKuRepository
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BukuKuApplication)
                val bukukuRepository = application.container.bukukuRepository
                DetailsViewModel(bukukuRepository = bukukuRepository)
            }
        }
    }
}
