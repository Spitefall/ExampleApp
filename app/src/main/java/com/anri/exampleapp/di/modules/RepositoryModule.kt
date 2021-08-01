package com.anri.exampleapp.di.modules

import com.anri.exampleapp.data.CharacterRepository
import com.anri.exampleapp.data.EpisodeRepository
import com.anri.exampleapp.data.LocationRepository
import com.anri.exampleapp.data.rest.ApiService
import com.anri.exampleapp.domain.repositories.CharacterRepo
import com.anri.exampleapp.domain.repositories.EpisodeRepo
import com.anri.exampleapp.domain.repositories.LocationRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCharacterRepo(apiService: ApiService): CharacterRepo =
        CharacterRepository(apiService)

    @Provides
    @Singleton
    fun provideLocationRepo(apiService: ApiService): LocationRepo =
        LocationRepository(apiService)

    @Provides
    @Singleton
    fun provideEpisodesRepo(apiService: ApiService): EpisodeRepo =
        EpisodeRepository(apiService)

}