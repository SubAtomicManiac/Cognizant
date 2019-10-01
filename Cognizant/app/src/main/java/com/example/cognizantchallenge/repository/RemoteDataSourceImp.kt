package com.example.cognizantchallenge.repository

import com.example.cognizantchallenge.dataclass.Album
import com.example.cognizantchallenge.net.TypicodeService
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(val typicodeService: TypicodeService): RemoteDataSource {

    override fun getAlbums(): Single<List<Album>> {
        return typicodeService.getAlbums()
    }
}