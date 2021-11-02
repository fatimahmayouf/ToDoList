package com.example.todoapplication.views.body

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.database.model.TasksModel

class TaskAdapter(val context: Context, val task_list: MutableList<TasksModel>,
                  val taskViewModel: TaskViewModel,
                  val fragmentManager: FragmentManager)
   : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>()

{


   class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val taskTitel: TextView = view.findViewById(R.id.task_title_textview)
      val completeCheckBox: CheckBox = view.findViewById(R.id.tesk_checkBox)
      val calender: ImageView = view.findViewById(R.id.calender_icon)
      //val dayDate: TextView = view.findViewById(R.id.date_textview)
      val alarm: ImageView = view.findViewById(R.id.alarm_icon)
      val location: ImageView = view.findViewById(R.id.location_icon)


   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
      val taskLayout = LayoutInflater.from(parent.context).inflate(
         R.layout.tasks_layout,
         parent,
         false
      )
      return TaskViewHolder(taskLayout)
   }


   override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
      val task = task_list[position]

      holder.apply {
         taskTitel.text = task.Title
         completeCheckBox.isChecked = task.compatibility


         calender.setImageResource(task.calender)
         //dayDate.text = task.date
         alarm.setImageResource(task.alarm)
         location.setImageResource(task.location)
      }
      holder.itemView.setOnClickListener {
         taskViewModel.selectedItemMutableLiveData.postValue(task)
         val fragmentUpdate = UpdateTaskDailog()
        // val updatefragmet = fragmentUpdate.onAttach(context)

         fragmentUpdate.show(fragmentManager, "EditDateDialogFragment")


      }

      /*holder.itemView.setOnTouchListener{
         taskViewModel.deletetask(task)

      }*/



   }
      override fun getItemCount(): Int {
         return task_list.size
      }


   fun delete(i:Int){
      taskViewModel.deletetask(task_list[i])
      notifyDataSetChanged()
   }



   fun update(i:Int,task:TasksModel){
      task_list.add(i,task)
      notifyDataSetChanged()
   }

   }

