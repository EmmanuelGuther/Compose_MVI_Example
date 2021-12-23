package com.emmanuelguther.domain.repository

import com.emmanuelguther.commons.ResultData
import kotlinx.coroutines.flow.Flow

interface PictureUrlsRepository {
    suspend fun getPictureUrls(): Flow<ResultData<List<String>>>
}