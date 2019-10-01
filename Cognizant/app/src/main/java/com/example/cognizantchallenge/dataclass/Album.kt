package com.example.cognizantchallenge.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "albums_table")
data class Album (
	 val userId : Int,
	 @PrimaryKey
	 val id : Int,
	val title : String
)