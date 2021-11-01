package com.example.todoapplication.views.body

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.Repository.TaskRepository
import com.example.todoapplication.database.model.TasksModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    private val taskItems = mutableListOf<TasksModel>()

    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var taskRecyclerViewAdapter: TaskAdapter

    lateinit var toggle: ActionBarDrawerToggle
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            TaskRepository.init(this)


            // add task button open fragment dialog
            val addTaskButton: Button = findViewById(R.id.add_task_button)
            addTaskButton.setOnClickListener {
                val fragmentAdd = AddTaskDaialog()
                fragmentAdd.show(supportFragmentManager,"Add task dialog")
            }



            val drawer: DrawerLayout = findViewById(R.id.DrawerLayout)
            val navView: NavigationView = findViewById(R.id.nav_view)
            toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
            drawer.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            var loginfragment = LoginFragment()
            var registerfragment = RegisterFragment()
            var fragmentlayout: FrameLayout = findViewById(R.id.fragment_layout)
            var mainlayout: ConstraintLayout = findViewById(R.id.main_layout)
             navView.setNavigationItemSelectedListener {

                 when(it.itemId){
                     R.id.password -> Toast.makeText(this, "password_clicked", Toast.LENGTH_SHORT).show()
                     R.id.app_bar_switch -> Toast.makeText(this, "notification_clicked", Toast.LENGTH_SHORT).show()
                     R.id.PrintItem -> Toast.makeText(this, "print_clicked", Toast.LENGTH_SHORT).show()
                     R.id.ShareItem -> Toast.makeText(this, "share_clicked", Toast.LENGTH_SHORT).show()
                     R.id.LogItem -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_layout,loginfragment).commit()
                         mainlayout.isInvisible
                         // لم تزبط معنا
                     }
                     R.id.RegisterItem -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_layout,registerfragment).commit()
                         mainlayout.isInvisible
                         // لم تزبط معنا
                     }

                 }
                 true
             }


            taskRecyclerView = findViewById(R.id.recyclerView)
            taskRecyclerViewAdapter = TaskAdapter(this,taskItems)
            taskRecyclerView.adapter = taskRecyclerViewAdapter


        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }
    }
