package com.example.cognizantchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cognizantchallenge.MyApp
import com.example.cognizantchallenge.R
import com.example.cognizantchallenge.di.home.DaggerHomeActivityComponent
import com.example.cognizantchallenge.di.home.HomeActivityModule
import com.example.cognizantchallenge.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeActivityViewModel: HomeViewModel

    lateinit var albumsAdapter: AlbumsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        DaggerHomeActivityComponent
            .builder()
            .appComponent((application as MyApp).component())
            .homeActivityModule(HomeActivityModule(this))
            .build()
            .inject(this)

        homeActivityViewModel.getAlbums()

        homeActivityViewModel.albumsObservable().observe(this,
            Observer {
                albumsAdapter.albums.clear()
                albumsAdapter.albums.addAll(it)
                albumsAdapter.notifyDataSetChanged()
            })

        homeActivityViewModel.errorObservable().observe(this,
            Observer {
                Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
            })

        homeActivityViewModel.progressObservable().observe(this, Observer {
            if (it == true){
                pb_home_activity.visibility = View.VISIBLE
            }else{
                pb_home_activity.visibility = View.GONE
            }
        })

    }

    private fun setUpRecyclerView(){
         albumsAdapter = AlbumsAdapter(mutableListOf())

        rv_albums.layoutManager = LinearLayoutManager(this)
        rv_albums.adapter = albumsAdapter

    }
}
