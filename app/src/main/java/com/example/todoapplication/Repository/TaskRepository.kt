package com.example.todoapplication.Repository

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.database.ToDoDatabase
import com.example.todoapplication.database.model.TasksModel
import com.example.todoapplication.database.model.UserModel
import java.lang.Exception


private const val DATABASE_NAME = "toDo-database"

class TaskRepository(context: Context) {


    private val database: ToDoDatabase =

        Room.databaseBuilder(

            context,
            ToDoDatabase:: class.java,
            DATABASE_NAME

        ).fallbackToDestructiveMigration()
            .build()





    private val taskDao = database.toDoDao()


    //tasks functions
    fun getTask() = taskDao.getTask()

    suspend fun addTask(taskModel : TasksModel) = taskDao.addTask(taskModel)
    suspend fun updateTask(taskModel: TasksModel)= taskDao.updateTask(taskModel)
    suspend fun deleteTask(taskModel: TasksModel)= taskDao.deleteTask(taskModel)


    //user functions

    fun getUser() = taskDao.getUser()
    suspend fun addUser(userModel : UserModel) = taskDao.addUser(userModel)
    suspend fun updateUser(userModel: UserModel)= taskDao.updateUser(userModel)



    companion object{

        //نبي نسوي اوبجكت من هذا الريبوزوتري ونستخدمه مرة وحده يعني singleton object

        // because we can not do object(parameter)
        private var instance: TaskRepository? = null

        fun init(context: Context){
            if(instance == null)
                instance = TaskRepository(context)
        }

        fun get(): TaskRepository{
            return instance ?: throw Exception("Task Repository must be initialized")
        }

    }


}