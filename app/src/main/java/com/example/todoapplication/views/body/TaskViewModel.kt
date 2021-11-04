package com.example.todoapplication.views.body

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplication.Repository.TaskRepository
import com.example.todoapplication.database.model.TasksModel
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {


    private val taskRepository = TaskRepository.get()

    /*========================================================================
                       Task entity
    ==========================================================================
     */
    var taskItems = taskRepository.getTask()


    fun addTask(
        Title: String,
        Description: String,
        Date: String,
        taskDate: String,
        taskTime: String

    ) {

        viewModelScope.launch {
            taskRepository.addTask(
                TasksModel( Title,
                Description,
                    Date,
                    taskDate,
                    taskTime))
        }
    }

    fun updateTask(taskModel:TasksModel){
        viewModelScope.launch {
            taskRepository.updateTask(taskModel)

        }
    }


    fun updateComp(complete:Boolean){
        viewModelScope.launch {
            taskRepository.completeTask(complete)

        }
    }

    fun deletetask(taskModel: TasksModel){
        viewModelScope.launch {
            taskRepository.deleteTask(taskModel)
        }

    }
    /*=======================================================================
                           End task Entity
    =========================================================================
     */
    var selectedItemMutableLiveData = MutableLiveData<TasksModel>()



}