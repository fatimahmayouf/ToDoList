package com.example.todoapplication.views.body

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R
import java.text.SimpleDateFormat
import java.util.*

class AddTaskDaialog : DialogFragment() {
    private val taskViewModel: TaskViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task_daialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEditText: EditText = view.findViewById(R.id.add_title_Edittext)
        val descriptionEditText: EditText = view.findViewById(R.id.add_description_edittext)
        val addButton: Button = view.findViewById(R.id.add_button)
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        // add task to the recyclerview
        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()) {

                taskViewModel.addTask(title,description, currentDate)
                Toast.makeText(activity, "New task added ", Toast.LENGTH_LONG).show()

                // close dialog fragment
                getDialog()?.dismiss()

            } else
                Toast.makeText(context, "all field must be filled", Toast.LENGTH_LONG).show()

        }
         // end

        var cancelButton: Button = view.findViewById(R.id.cancel_add_button)

        cancelButton.setOnClickListener {
            // close dialog
            getDialog()?.dismiss()

            //findNavController().popBackStack()
        }
    }

}