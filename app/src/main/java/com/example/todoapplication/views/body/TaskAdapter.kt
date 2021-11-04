package com.example.todoapplication.views.body

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.database.model.TasksModel
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.util.*

class TaskAdapter( val context: Context, val task_list: MutableList<TasksModel>,
                  val taskViewModel: TaskViewModel,
                  val fragmentManager: FragmentManager)
   : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

   val CHANNEL_ID = "Channel id"
   val CHANNEL_NAME = "Channel name"
   val NOTIFICATION_ID = 0
   val notificationManager = NotificationManagerCompat.from(context)



   val sdf = SimpleDateFormat("dd/M/yyyy")
   val currentDate2 = sdf.format(Date())

   /*==================================================================
                          view holder class
   ====================================================================
    */

   class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val taskTitel: TextView = view.findViewById(R.id.task_title_textview)
      val completeCheckBox: CheckBox = view.findViewById(R.id.tesk_checkBox)
      val dueDate: TextView = view.findViewById(R.id.date_recycler_textview)
      val dueTime: TextView = view.findViewById(R.id.time_recycler_textview)
   }
   // End



   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
      val taskLayout = LayoutInflater.from(parent.context).inflate(
         R.layout.tasks_layout,
         parent,
         false
      )
      return TaskViewHolder(taskLayout)
   }
     /*===============================================================================
                               on Bind function
      ================================================================================
  */
   @RequiresApi(Build.VERSION_CODES.M)
   override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {

      val task = task_list[position]
      holder.apply {
         taskTitel.text = task.Title
         completeCheckBox.isChecked = task.compatibility
         dueDate.text = task.taskdate
         dueTime.text = task.tasktime

      }
//========================================================================
      val format = SimpleDateFormat("dd/MM/yyyy")
      var currentDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
      } else {

         TODO("VERSION.SDK_INT < O")
      }

     val deadline = format.parse(task.taskdate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

      if (deadline.isBefore(currentDate)) {
         holder.dueDate.setTextColor(context.getColor(R.color.red))
      } else {
         holder.dueDate.setTextColor(context.getColor(R.color.green))
      }
    //  ========================================================================


      holder.itemView.setOnClickListener {
         taskViewModel.selectedItemMutableLiveData.postValue(task)
         val fragmentUpdate = UpdateTaskDailog()
         // val updatefragmet = fragmentUpdate.onAttach(context)

         fragmentUpdate.show(fragmentManager, "EditDateDialogFragment")

      }
      holder.completeCheckBox.setOnClickListener {
         task.compatibility = holder.completeCheckBox.isChecked
         if (holder.completeCheckBox.isChecked) {
            holder.completeCheckBox.setText("Well Done")
            holder.itemView.setBackgroundColor(context.getColor(R.color.Gray))
            taskViewModel.updateTask(task)
         }

      }

       // notification
      if (holder.dueDate.text.toString()==currentDate2) {
         val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(holder.taskTitel.text.toString())
            .setContentText(holder.dueDate.text.toString())
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
         notificationManager.notify(NOTIFICATION_ID, notification)

      }

   }
         /*====================================================================
                                  On Bind End here
           ======================================================================
 */
   override fun getItemCount(): Int {
      return task_list.size
   }

    // to call in in the swipe
   fun delete(i: Int) {
      taskViewModel.deletetask(task_list[i])
      notifyDataSetChanged()
   }
   }


