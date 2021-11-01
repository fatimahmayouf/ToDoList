package com.example.todoapplication.views.body

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapplication.R
import com.example.todoapplication.Repository.TaskRepository
import com.example.todoapplication.database.model.TasksModel
import com.example.todoapplication.database.model.UserModel
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {


    private val taskRepository = TaskRepository.get()

    /*========================================================================
                       Task entity
    ==========================================================================
     */
    var taskItems = taskRepository.getTask()

    var selectedTaskMutableLiveData = MutableLiveData<TasksModel>()

    fun addTask( Title: String, Description: String) {

        viewModelScope.launch {
            taskRepository.addTask(
                TasksModel( Title,
                Description,
                false,
            R.drawable.ic_baseline_calendar_today_24,
            R.drawable.ic_baseline_notifications_24,
            R.drawable.ic_baseline_location_on_24)
            )
        }
    }

    fun updateTask(taskModel:TasksModel){
        viewModelScope.launch {
            taskRepository.updateTask(taskModel)

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


    /*=======================================================================
                           User Entity
    =========================================================================
     */
    var user = taskRepository.getUser()


    fun addUser(fullName: String, email: String, password: String) {

        viewModelScope.launch {// لانها تشتغل في الباك قراوند كروتين لازم نستخدم فيو مودل سكوب
            taskRepository.addUser(UserModel( fullName,
                email,
                password,
            true,
            R.drawable.person3))//يطلب التاسك مودل
        }
    }

    fun updateUser(userModel:UserModel){
        viewModelScope.launch {
            taskRepository.updateUser(userModel)

        }
    }

    /*=======================================================================
                           End user Entity
    =========================================================================
     */

}