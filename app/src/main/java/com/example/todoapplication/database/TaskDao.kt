package com.example.todoapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.todoapplication.database.model.TasksModel


@Dao
interface TaskDao {

    // tasks functions
    @Insert
    suspend fun addTask(taskModel: TasksModel)

    @Query("SELECT * FROM TasksModel")
    fun getTask() : LiveData<List<TasksModel>>// because we will retrieve some thing

    @Update
    suspend fun updateTask(taskModel: TasksModel)

    @Delete
    suspend fun deleteTask(taskModel: TasksModel)

}