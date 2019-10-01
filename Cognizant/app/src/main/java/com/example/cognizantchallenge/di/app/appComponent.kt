package com.example.cognizantchallenge.di.app

import com.example.cognizantchallenge.MyApp
import com.example.cognizantchallenge.repository.AlbumsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,RepositoryModule::class,DatabaseModule::class])
interface appComponent {
    fun inject(myApp: MyApp)

    fun repository(): AlbumsRepository
}