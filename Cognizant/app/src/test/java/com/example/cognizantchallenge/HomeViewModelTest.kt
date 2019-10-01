package com.example.cognizantchallenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.cognizantchallenge.dataclass.Album
import com.example.cognizantchallenge.repository.AlbumsRepository
import com.example.cognizantchallenge.viewmodel.HomeViewModel
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {
    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var albumsRepository: AlbumsRepository

    lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(albumsRepository)
    }

    @Test
    fun getAlbumSuccess() {

        val albumObserver: Observer<List<Album>> = mock()
        val errorObserver: Observer<String> = mock()
        val processObserver: Observer<Boolean> = mock()
        val albums = listOf(Album(1, 1, "Album 1"), Album(2, 2, "Album 2"))
        `when`(albumsRepository.getAlbumsSortedAlbums()).thenReturn(Observable.just(albums))

        viewModel.albumsObservable().observeForever(albumObserver)
        viewModel.progressObservable().observeForever(processObserver)
        viewModel.errorObservable().observeForever(errorObserver)

        viewModel.getAlbums()

        verify(albumObserver, times(1)).onChanged(albums)
        verify(errorObserver, times(0)).onChanged(ArgumentMatchers.any())
        verify(processObserver, times(1)).onChanged(true)
        verify(processObserver, times(1)).onChanged(false)
    }


    @Test
    fun getAlbumError() {

        val albumObserver: Observer<List<Album>> = mock()
        val errorObserver: Observer<String> = mock()
        val processObserver: Observer<Boolean> = mock()
        val errorMessage = "Exception"
        `when`(albumsRepository.getAlbumsSortedAlbums()).thenReturn(
            Observable.error(
                RuntimeException(errorMessage)
            )
        )

        viewModel.albumsObservable().observeForever(albumObserver)
        viewModel.progressObservable().observeForever(processObserver)
        viewModel.errorObservable().observeForever(errorObserver)

        viewModel.getAlbums()

        verify(albumObserver, times(0)).onChanged(ArgumentMatchers.any())
        verify(errorObserver, times(1)).onChanged(errorMessage)
        verify(processObserver, times(1)).onChanged(true)
        verify(processObserver, times(1)).onChanged(false)
    }



}

