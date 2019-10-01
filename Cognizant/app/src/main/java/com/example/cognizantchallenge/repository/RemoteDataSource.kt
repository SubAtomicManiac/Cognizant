package com.example.cognizantchallenge.repository

import com.example.cognizantchallenge.dataclass.Album
import io.reactivex.Single

interface RemoteDataSource {
    fun getAlbums():Single<List<Album>>
}