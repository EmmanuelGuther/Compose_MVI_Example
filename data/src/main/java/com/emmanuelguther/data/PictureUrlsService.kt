package com.emmanuelguther.data

import com.emmanuelguther.commons.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class PictureUrlsService @Inject constructor() {
    fun getPictureUrls(): Flow<ResultData<List<String>>> = callbackFlow {
        launch(Dispatchers.IO) {
            //Simulate api delay
            delay(2000)
            trySend(ResultData.Loading())
            trySend(
                ResultData.Success(
                    listOf(
                        "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/6.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/7.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/8.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/9.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/10.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/11.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/12.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/13.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/14.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/15.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/16.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/17.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/18.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/19.jpeg",
                        "https://rickandmortyapi.com/api/character/avatar/20.jpeg",
                    )
                )
            )
        }
        awaitClose { close() }
    }
}

