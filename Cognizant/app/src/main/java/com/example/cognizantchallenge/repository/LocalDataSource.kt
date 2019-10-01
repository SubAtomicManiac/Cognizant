package com.example.cognizantchallenge.repository

import com.example.cognizantchallenge.dataclass.Album
import io.reactivex.Single

interface LocalDataSource {

    fun getAlbums(): Single<List<Album>>

    fun addAlbums(albums:List<Album>)
}