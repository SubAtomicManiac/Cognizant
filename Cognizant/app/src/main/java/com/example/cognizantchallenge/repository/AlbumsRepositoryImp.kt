package com.example.cognizantchallenge.repository

import com.example.cognizantchallenge.dataclass.Album
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlbumsRepositoryImp (private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource):AlbumsRepository {

    override fun getAlbumsSortedAlbums(): Observable<List<Album>> {
      return remoteDataSource.getAlbums()
          .doOnSuccess(this::addDataToDb)
          .toObservable()
          .observeOn(Schedulers.computation())
          .onErrorResumeNext(getDataFromDb())
          .flatMap { mapper -> Observable.fromIterable(mapper) }
          .toSortedList { album, album2 -> album.title.compareTo(album2.title) }
          .toObservable()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())


    }

    private fun getDataFromDb(): Observable<List<Album>>{

        return localDataSource.getAlbums().toObservable()
    }

    private fun addDataToDb(albums: List<Album>){
     localDataSource.addAlbums(albums)
    }
}