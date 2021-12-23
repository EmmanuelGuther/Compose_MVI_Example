package com.emmanuelguther.di


import com.emmanuelguther.data.PictureUrlsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {

    @Singleton
    @Provides
    fun providesFilesRepository() = PictureUrlsService()

}