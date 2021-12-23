package com.emmanuelguther.features.main

import androidx.lifecycle.viewModelScope
import com.emmanuelguther.commons.ResultData
import com.emmanuelguther.core_presentation.*
import com.emmanuelguther.domain.usecase.GetPictureUrlsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(private val getPictureUrlsUseCase: GetPictureUrlsUseCase) :
    MViewModel<MainViewModel.MainScreenState, ViewModelGenericError, MainViewModel.Event, MainViewModel.Effect>() {

    init {
        loadImage()
    }

    fun loadImage() {
        viewModelScope.launch {
            getPictureUrlsUseCase.invoke().collect {
                when (it) {
                    is ResultData.Loading -> updateState(ViewModelState.Loading())
                    is ResultData.Failure -> updateState(ViewModelState.Error(ViewModelGenericError.Connection))
                    is ResultData.Success -> updateState(ViewModelState.Loaded(MainScreenState(it.data)))
                }
            }
        }
    }

    override fun handleEvent(event: Event) {
        when (event) {
            Event.OnBackPressed -> {}
            is Event.OnClickImage -> {
                setEffect { Effect.NavigateToDetailImage(event.imageUrl) }
            }
        }
    }

    data class MainScreenState(val imageUrls: List<String>)

    sealed class Event : UiEvent {
        object OnBackPressed : Event()
        data class OnClickImage(val imageUrl: String) : Event()
    }

    sealed class Effect : UiEffect {
        object ShowDialogX : Effect()
        data class NavigateToDetailImage(val imageUrl: String) : Effect()
    }

}

