package com.example.cognizantchallenge.di.app

import android.app.Application
import androidx.room.Room
import com.example.cognizantchallenge.common.Constants
import com.example.cognizantchallenge.db.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application){

    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): Database{
        return Room.databaseBuilder(application,Database::class.java,Constants.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = application
}