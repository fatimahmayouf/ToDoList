package com.example.todoapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.todoapplication.database.model.TasksModel
import com.example.todoapplication.database.model.UserModel


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

// user profile functions

    @Insert
    suspend fun addUser(userModel: UserModel)

    @Query("SELECT * FROM UserModel")
    fun getUser() : LiveData<List<UserModel>>

    @Update
    suspend fun updateUser(userModel: UserModel)


}