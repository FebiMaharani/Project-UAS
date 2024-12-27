package id.febimaharani.bukuku.ui.screens.favorite_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import id.febimaharani.bukuku.R
import id.febimaharani.bukuku.ui.screens.components.ErrorScreen
import id.febimaharani.bukuku.ui.screens.components.LoadingScreen
import id.febimaharani.bukuku.ui.screens.query_screen.*

@Composable
fun FavoritesScreen(
    viewModel: QueryViewModel,
    bukukuUiState: QueryUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        if (!viewModel.favoriteBooks.isEmpty()) {
            when (bukukuUiState) {
                is QueryUiState.Loading -> LoadingScreen(modifier)
                is QueryUiState.Success -> GridList(
                    bukukuList = bukukuUiState.bukukuList,
                    viewModel = viewModel,
                    modifier = modifier,
                    onDetailsClick = { }
                )
                else -> ErrorScreen(retryAction, modifier)
            }
        } else {
            Box(modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.NoFavoriteBooksText))
            }
        }
    }
}