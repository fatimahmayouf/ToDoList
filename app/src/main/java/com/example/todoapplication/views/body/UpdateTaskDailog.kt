package com.example.todoapplication.views.body

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R
import com.example.todoapplication.database.model.TasksModel
import java.text.SimpleDateFormat
import java.util.*

class UpdateTaskDailog:DialogFragment(){

    private val taskViewModel: TaskViewModel by activityViewModels()
    private lateinit var listTask: TasksModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_task_dailog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val title: EditText = view.findViewById(R.id.update_title_edittext)
        val Description: EditText = view.findViewById(R.id.update_description_edittext)
        val date: TextView = view.findViewById(R.id.dayDate_textview)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        var toDayDate = sdf.format(Date())

        val cancel_update: Button = view.findViewById(R.id.cancel_update_button)
        val updateButton : Button = view.findViewById(R.id.update_button)

        taskViewModel.selectedItemMutableLiveData.observe(viewLifecycleOwner,
            {

                Log.d("SELECTED_TASK" , it.toString())

                it?.let { item->

                    Log.d("SELECTED_TASK" , item.toString())
                    title.setText(item.Title)
                    Description.setText(item.Description)
                    date.setText(item.creationDate)


                    listTask = item

                }
            })

        updateButton.setOnClickListener {
            var titlee = title.text.toString()
            var Descriptionn = Description.text.toString()
            var dayDate = toDayDate.toString()

            listTask.Title = titlee
            listTask.Description = Descriptionn
            listTask.creationDate = dayDate


            taskViewModel.updateTask(listTask)
            Toast.makeText(activity, "Task updated", Toast.LENGTH_SHORT).show()
            getDialog()?.dismiss()
            //close fragment

        }


        cancel_update.setOnClickListener {
            // close dialog

            getDialog()?.dismiss()
            //findNavController().popBackStack()


        }
    }


}