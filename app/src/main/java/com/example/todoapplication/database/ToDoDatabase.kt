package com.example.todoapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.database.model.TasksModel
import com.example.todoapplication.database.model.UserModel

@Database(entities = [UserModel::class,TasksModel::class], version = 1)

abstract class ToDoDatabase:RoomDatabase () {

    abstract fun toDoDao(): TaskDao
}