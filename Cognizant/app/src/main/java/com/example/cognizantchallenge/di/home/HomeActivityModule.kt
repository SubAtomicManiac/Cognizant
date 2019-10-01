package com.example.cognizantchallenge.di.home

import androidx.lifecycle.ViewModelProviders
import com.example.cognizantchallenge.ui.HomeActivity
import com.example.cognizantchallenge.viewmodel.HomeViewModel
import com.example.cognizantchallenge.viewmodel.factory.HomeViewModelFactory
import com.example.cognizantchallenge.repository.AlbumsRepository
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(val homeActivity: HomeActivity) {

    @Provides
    @HomeActivityScope
    fun provideHomeViewModelFactory(albumsRepository: AlbumsRepository): HomeViewModelFactory {

        return HomeViewModelFactory(
            albumsRepository
        )
    }

    @Provides
    @HomeActivityScope
    fun provideHomeViewModel(homeActivityViewModelFactory: HomeViewModelFactory) =
        ViewModelProviders.of(homeActivity,homeActivityViewModelFactory).get(HomeViewModel::class.java)
}