package com.example.cognizantchallenge.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cognizantchallenge.repository.AlbumsRepository
import com.example.cognizantchallenge.viewmodel.HomeViewModel

class HomeViewModelFactory(val albumsRepository: AlbumsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(albumsRepository) as T
    }
}