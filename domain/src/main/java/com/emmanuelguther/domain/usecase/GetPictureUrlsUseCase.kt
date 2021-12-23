package com.emmanuelguther.domain.usecase

import com.emmanuelguther.commons.ResultData
import com.emmanuelguther.domain.repository.PictureUrlsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPictureUrlsUseCase @Inject constructor(private val repository: PictureUrlsRepository) {
    suspend operator fun invoke(): Flow<ResultData<List<String>>> = repository.getPictureUrls()
}