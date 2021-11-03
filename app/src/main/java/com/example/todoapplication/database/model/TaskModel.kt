package com.example.todoapplication.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TasksModel(
      var Title: String,
      var Description: String,
      var creationDate: String,
      var taskdate: String?,
      var tasktime: String?,
      var compatibility: Boolean = false,

      @PrimaryKey(autoGenerate = true)
      var id: Int = 0


 )
