package com.emmanuelguther.di


import com.emmanuelguther.data.PictureUrlsService
import com.emmanuelguther.data.repository.PictureUrlsRepositoryImpl
import com.emmanuelguther.domain.repository.PictureUrlsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Singleton
    @Provides
    fun providesFilesRepository(pictureUrlsService: PictureUrlsService): PictureUrlsRepository = PictureUrlsRepositoryImpl(pictureUrlsService)

}