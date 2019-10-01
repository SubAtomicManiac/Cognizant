package com.example.cognizantchallenge.di.app

import com.example.cognizantchallenge.db.Database
import com.example.cognizantchallenge.net.TypicodeService
import com.example.cognizantchallenge.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAlbumRepository(remoteDataSource: RemoteDataSource,localDataSource: LocalDataSource): AlbumsRepository
            = AlbumsRepositoryImp(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideRemoteDataSource(typicodeService: TypicodeService) :RemoteDataSource{
        return RemoteDataSourceImp(typicodeService)
    }

    //Local datasource
    @Provides
    @Singleton
    fun provideLocalDataSource(database: Database): LocalDataSource{
        return LocalDataSourceImp(database)
    }

}