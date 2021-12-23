package com.emmanuelguther.features.main

import com.emmanuelguther.core_presentation.ViewModelGenericError
import com.emmanuelguther.core_presentation.ViewModelState
import com.emmanuelguther.domain.usecase.GetPictureUrlsUseCase
import com.emmanuelguther.features.CoroutinesTestRule
import com.emmanuelguther.features.FakeSuccessPictureUrlsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class MainViewModelTest{
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `Call GetPicturesUseCase result Success ViewModelState updated`() = runBlockingTest {
       val fakeRepository = FakeSuccessPictureUrlsRepository(FakeSuccessPictureUrlsRepository.ResultType.Success)
        val uc = GetPictureUrlsUseCase(fakeRepository)
        val vm = MainViewModel(uc)

        vm.loadImage()
        val job = this.launch {
            vm.state.collect {
                Assert.assertEquals(ViewModelState.Loaded(content = MainScreenState(imageUrls = fakeRepository.result), error = null, refreshing = false), it)
            }
        }
        job.cancel()
    }

    @Test
    fun `Call GetPicturesUseCase result Failure ViewModelState updated`() = runBlockingTest {
        val fakeRepository = FakeSuccessPictureUrlsRepository(FakeSuccessPictureUrlsRepository.ResultType.Failure)
        val uc = GetPictureUrlsUseCase(fakeRepository)
        val vm = MainViewModel(uc)

        vm.loadImage()
        val job = this.launch {
            vm.state.collect {
                Assert.assertEquals(ViewModelGenericError.Connection, it.error())
            }
        }
        job.cancel()
    }
}