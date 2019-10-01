package com.example.cognizantchallenge.repository

import com.example.cognizantchallenge.dataclass.Album
import com.example.cognizantchallenge.db.Database
import io.reactivex.Single
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(val database: Database):LocalDataSource {

    override fun getAlbums(): Single<List<Album>> {
        return database.albumsDao().getAllAblums()
    }

    override fun addAlbums(albums: List<Album>) {
        database.albumsDao().addAllAlbums(albums)
    }

}