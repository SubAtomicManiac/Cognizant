package com.example.cognizantchallenge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cognizantchallenge.dataclass.Album
import io.reactivex.Single

@Dao
interface AlbumsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllAlbums(albums:List<Album>)

    @Query("SELECT * FROM albums_table")
    fun getAllAblums(): Single<List<Album>>
}