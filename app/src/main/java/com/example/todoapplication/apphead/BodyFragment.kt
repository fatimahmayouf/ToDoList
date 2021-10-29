package com.example.todoapplication.apphead

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.todoapplication.R

class BodyFragment : Fragment() {

    val options: List<String> = listOf("All Task","due date","Location","Completed","Uncompleted")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val spinner:Spinner = view.findViewById(R.id.filter_spinner)
        //var optionAdapter = ArrayAdapter(this,spinner,options)

       // val a = spinner.onItemSelectedListener

       // var dropAdapter = ArrayAdapter(a, android.R.layout.simple_spinner_item, options)
       // spinner.adapter = dropAdapter


        //var optionAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
      //  spinner.adapter =optionAdapter


    }
}