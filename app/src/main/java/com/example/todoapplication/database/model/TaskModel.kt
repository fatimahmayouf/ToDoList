package com.example.todoapplication.database.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded


 @Entity
data class TasksModel(
     var Title: String,
     var Description: String,
     var creationDate: String,

     @DrawableRes
     val calender: Int,
     //val date: Int,
     @DrawableRes
     val alarm: Int,
     @DrawableRes
     val location: Int,

     var compatibility: Boolean = false,

     @PrimaryKey(autoGenerate = true)
     var id :Int = 0


 )
