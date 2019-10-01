package com.example.cognizantchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cognizantchallenge.dataclass.Album
import com.example.cognizantchallenge.repository.AlbumsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val albumsRepository: AlbumsRepository): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val albumsObservable : MutableLiveData<List<Album>> = MutableLiveData()
    private val showProgressDialog: MutableLiveData<Boolean> = MutableLiveData()
    private val errorObservable: MutableLiveData<String> = MutableLiveData()

    fun getAlbums(){
        compositeDisposable.add(
            albumsRepository.getAlbumsSortedAlbums()
                .doOnSubscribe { showProgressDialog.postValue(true) }
                .doOnComplete { showProgressDialog.value = false }
                .doOnError { showProgressDialog.value = false }
                .subscribe ({albums -> albumsObservable.value = albums},
                    {error -> errorObservable.value = error.message.toString()} )
        )

    }

     fun albumsObservable() = albumsObservable

     fun progressObservable() = showProgressDialog

     fun errorObservable() = errorObservable


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}