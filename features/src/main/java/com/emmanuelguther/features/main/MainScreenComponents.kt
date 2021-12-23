package com.emmanuelguther.features.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.emmanuelguther.core_presentation.LinkViewModelLifecycle
import com.emmanuelguther.core_presentation.ViewModelGenericError
import com.emmanuelguther.core_presentation.ViewModelState
import com.emmanuelguther.features.FullScreenLoading
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@Composable
fun MainScreen(viewModel: MainViewModel) {
    LinkViewModelLifecycle(viewModel)

    val state by viewModel.state.collectAsState(initial = ViewModelState.initialState)
    Content(state, viewModel)

    val effect by viewModel.effect.collectAsState(initial = null)
    Effects(effect)
}

@ExperimentalCoroutinesApi
@Composable
private fun Content(
    state: ViewModelState<out MainViewModel.MainScreenState, ViewModelGenericError>,
    viewModel: MainViewModel
) {
    Surface(Modifier.fillMaxSize()) {
        when {
            state.loading() -> FullScreenLoading()
            state is ViewModelState.Loaded -> ImageList(state.content()) { onClickedImage ->
                viewModel.setEvent(MainViewModel.Event.OnClickImage(onClickedImage))
            }

            state is ViewModelState.Error -> Log.e("ERROR", "ERROR")
        }
    }
}

@ExperimentalCoroutinesApi
@Composable
private fun Effects(effect: MainViewModel.Effect?) {
    when (effect) {
        MainViewModel.Effect.ShowDialogX -> {}
        is MainViewModel.Effect.NavigateToDetailImage -> {}
        null -> {}
    }
}

@ExperimentalCoroutinesApi
@Composable
private fun ImageList(content: MainViewModel.MainScreenState?, onClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content?.imageUrls?.let { itImageUrls ->
            items(itImageUrls) {
                ImageRow(imageUrl = it, onClick)
            }
        }
    }
}

@Composable
private fun ImageRow(imageUrl: String, onClick: (String) -> Unit) {
    Box(modifier = Modifier
        .clickable { onClick.invoke(imageUrl) }) {
        Image(
            painter = rememberImagePainter(data = imageUrl), contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )
    }
}

