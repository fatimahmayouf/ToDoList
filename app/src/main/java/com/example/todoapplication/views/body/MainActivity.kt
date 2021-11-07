package com.example.todoapplication.views.body

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.get
import androidx.core.view.isInvisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.Repository.TaskRepository
import com.example.todoapplication.database.model.TasksModel
import com.google.android.material.navigation.NavigationView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    private val taskItems = mutableListOf<TasksModel>()
    private  val taskViewModel: TaskViewModel by viewModels()
   // private lateinit var selectedItem: TasksModel
    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var taskRecyclerViewAdapter: TaskAdapter
    lateinit var toggle: ActionBarDrawerToggle

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val sdf = SimpleDateFormat("dd/M/yyyy")
            val currentDate = sdf.format(Date())
            val toDayTxt: TextView = findViewById(R.id.toDay_TextView)
            toDayTxt.text = "Day date is $currentDate"


            /*==========================================================
                             declaration of recyclerview & adapter
              ===========================================================*/

            taskRecyclerView = findViewById(R.id.recyclerView)
            taskRecyclerViewAdapter =
                TaskAdapter(this, taskItems, taskViewModel, supportFragmentManager)
            taskRecyclerView.adapter = taskRecyclerViewAdapter
            taskRecyclerViewAdapter
            createNotificationChannel()

            /*==========================================================
                             Edn declaration
              ===========================================================*/

            // add task button open fragment dialog
            val addTaskButton: Button = findViewById(R.id.add_task_button)

            addTaskButton.setOnClickListener {
                val fragmentAdd = AddTaskDaialog()
                fragmentAdd.show(supportFragmentManager, "Add task dialog")
            }

            taskViewModel.taskItems.observe(this, Observer {
                it?.let { items ->
                    taskItems.clear()

                    taskItems.addAll(items)
                    taskRecyclerViewAdapter.notifyDataSetChanged()

                }
            })
            // End Add button (insert)

            // delete task by swiping
            val swipeItem = object : SwipeItem(this) {

                @RequiresApi(Build.VERSION_CODES.Q)
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    when (direction) {

                        ItemTouchHelper.LEFT -> {

                        }

                        ItemTouchHelper.RIGHT ->taskRecyclerViewAdapter.delete(viewHolder.adapterPosition)
                    }
                }
            }
           val touchHelper = ItemTouchHelper(swipeItem)
            touchHelper.attachToRecyclerView(taskRecyclerView)
            // End delete
           /*===========================================================================
                            implement drawer navigation
           =============================================================================
            */

            val drawer: DrawerLayout = findViewById(R.id.DrawerLayout)
           // val navView: NavigationView = findViewById(R.id.nav_view)
            toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
            drawer.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            /* navView.setNavigationItemSelectedListener {

                 when(it.itemId){
                     R.id.item3 ->
                 }
             }

             */



        }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }
           /*========================================================================
                                     End Drawer
             ==========================================================================
           */

    fun createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(taskRecyclerViewAdapter.CHANNEL_ID,
                taskRecyclerViewAdapter.CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor= Color.GREEN
                enableLights(true)

            }

            val manager= getSystemService(Context.NOTIFICATION_SERVICE)as
                    NotificationManager
            manager.createNotificationChannel(channel)

        }
    }
}






