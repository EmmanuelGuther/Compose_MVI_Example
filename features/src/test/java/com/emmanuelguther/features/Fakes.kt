package com.emmanuelguther.features

import com.emmanuelguther.commons.ResultData
import com.emmanuelguther.domain.repository.PictureUrlsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSuccessPictureUrlsRepository(private val resultType: ResultType) : PictureUrlsRepository {
    val result = listOf("a", "b", "c")
    override suspend fun getPictureUrls(): Flow<ResultData<List<String>>> {
        when(resultType){
            ResultType.Failure ->  return flowOf(ResultData.Failure("ERROR"))
            ResultType.Success ->  return flowOf(ResultData.Success(result))
        }

    }

    sealed class ResultType {
        object Success : ResultType()
        object Failure : ResultType()
    }
}


