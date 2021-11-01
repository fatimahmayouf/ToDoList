package com.example.todoapplication.views.body

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R

class UpdateTaskDailog:DialogFragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_task_dailog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancel_update: Button = view.findViewById(R.id.cancel_update_button)
        val update : Button = view.findViewById(R.id.update_button)


        cancel_update.setOnClickListener {
            findNavController().popBackStack()


        }
    }


}