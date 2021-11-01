package com.example.todoapplication.database.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded


@Entity
data class UserModel (

    var fullName: String,
    var email: String,
    var password: String,

    var notivication: Boolean,

    @DrawableRes
    val userImage:Int,

    @PrimaryKey(autoGenerate = true)
    var userid: Int = 0,

    @Embedded
    val task: TasksModel? = null

)

 @Entity
data class TasksModel(
     var Title: String,
     var Description: String,
     var compatibility: Boolean,


     @DrawableRes
     val calender: Int,
     //val date: Int,
     @DrawableRes
     val alarm: Int,
     @DrawableRes
     val location: Int,

     @PrimaryKey(autoGenerate = true)
     var id :Int = 0


 )
