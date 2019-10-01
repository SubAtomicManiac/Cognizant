package com.example.cognizantchallenge

import android.app.Application
import com.example.cognizantchallenge.di.app.*

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
      component().inject(this)

    }

    fun component(): appComponent = DaggerappComponent.builder().networkModule(NetworkModule())
        .repositoryModule(
        RepositoryModule()
    )
        .databaseModule(DatabaseModule(this)).build()
}