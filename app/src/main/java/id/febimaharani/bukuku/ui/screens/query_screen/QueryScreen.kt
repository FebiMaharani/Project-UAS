package id.febimaharani.bukuku.ui.screens.query_screen

import android.view.KeyEvent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import id.febimaharani.bukuku.R
import id.febimaharani.bukuku.model.Book
import id.febimaharani.bukuku.ui.screens.components.ErrorScreen
import id.febimaharani.bukuku.ui.screens.components.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueryScreen(
    modifier: Modifier = Modifier,
    viewModel: QueryViewModel,
    retryAction: () -> Unit,
    onDetailsClick: (Book) -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState().value
    val uiStateQuery = viewModel.uiStateSearch.collectAsState().value
    val focusManager = LocalFocusManager.current

    Column {
        OutlinedTextField(
            value = uiStateQuery.query,
            onValueChange = { viewModel.updateQuery(it) },
            singleLine = true,
            placeholder = {
                Text(text = stringResource(R.string.search_placeholder))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    focusManager.clearFocus()
                    viewModel.getBooks(uiStateQuery.query)
                }
            ),
            modifier = Modifier
                .onKeyEvent { e ->
                    if (e.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                        focusManager.clearFocus()
                        viewModel.getBooks(uiStateQuery.query)
                    }
                    false
                }
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        )

        if (uiStateQuery.searchStarted) {
            when (uiState) {
                is QueryUiState.Loading -> LoadingScreen(modifier)
                is QueryUiState.Success -> GridList(
                    viewModel = viewModel,
                    bukukuList = uiState.bukukuList,
                    modifier = modifier,
                    onDetailsClick = onDetailsClick,
                )
                is QueryUiState.Error ->
                    ErrorScreen(retryAction = retryAction, modifier)
            }
        }
    }
}