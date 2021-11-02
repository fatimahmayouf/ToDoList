package com.example.todoapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.database.model.TasksModel

@Database(entities = [TasksModel::class], version = 4)

abstract class ToDoDatabase:RoomDatabase () {

    abstract fun toDoDao(): TaskDao
}