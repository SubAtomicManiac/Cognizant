package com.example.cognizantchallenge.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.cognizantchallenge.common.Constants
import com.example.cognizantchallenge.dataclass.Album

@Database(entities = [Album::class],version = Constants.DATABASE_VERSION,exportSchema = false)
abstract class Database: RoomDatabase(){
    abstract fun albumsDao():AlbumsDao
}