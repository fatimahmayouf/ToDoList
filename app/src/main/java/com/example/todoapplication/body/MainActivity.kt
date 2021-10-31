package com.example.todoapplication.body

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.todoapplication.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


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


        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }
    }
