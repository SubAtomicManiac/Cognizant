package com.example.cognizantchallenge.net

import com.example.cognizantchallenge.dataclass.Album
import io.reactivex.Single
import retrofit2.http.GET

interface TypicodeService {

    @GET("albums")
    fun getAlbums(): Single<List<Album>>
}