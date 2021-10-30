package com.example.todoapplication.apphead

import android.app.Activity
import android.os.Bundle
import android.text.Layout
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.graphics.rotationMatrix
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.set
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.todoapplication.R
import com.google.android.material.navigation.NavigationView

class BodyFragment : Fragment() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.profile_menu,menu)
       return  super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val drawer : DrawerLayout?= view?.findViewById(R.id.DrawerLayout)
        val navView: NavigationView? = view?.findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(Activity(), drawer, R.string.open, R.string.close)
        drawer?.addDrawerListener(toggle)
        toggle.syncState()

        return toggle.onOptionsItemSelected(item)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*==================================================================================
                          setting navigation drawer to drawerLayout
        ====================================================================================*/





        /*==================================================================================
                                 End navigation Drawer
         ====================================================================================*/


        // add task button open Dialog Fragment

        val addTaskButton: Button = view.findViewById(R.id.add_task_button)

        addTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_bodyFragment2_to_addTaskDaialog)
        }

        // end


    }

   /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }*/

}



//val spinner:Spinner = view.findViewById(R.id.filter_spinner)
//var optionAdapter = ArrayAdapter(this,spinner,options)

// val a = spinner.onItemSelectedListener

// var dropAdapter = ArrayAdapter(a, android.R.layout.simple_spinner_item, options)
// spinner.adapter = dropAdapter


//var optionAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
//  spinner.adapter =optionAdapter