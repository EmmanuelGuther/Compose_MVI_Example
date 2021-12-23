package com.emmanuelguther.data.repository

import com.emmanuelguther.commons.ResultData
import com.emmanuelguther.data.PictureUrlsService
import com.emmanuelguther.domain.repository.PictureUrlsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ExperimentalCoroutinesApi
class PictureUrlsRepositoryImpl @Inject constructor(private val pictureUrlsService: PictureUrlsService) : PictureUrlsRepository {
    override suspend fun getPictureUrls(): Flow<ResultData<List<String>>> = pictureUrlsService.getPictureUrls()
}