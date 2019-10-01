package com.example.cognizantchallenge.repository

import com.example.cognizantchallenge.dataclass.Album
import io.reactivex.Observable
import io.reactivex.Single

interface AlbumsRepository {
    fun getAlbumsSortedAlbums(): Observable<List<Album>>
}