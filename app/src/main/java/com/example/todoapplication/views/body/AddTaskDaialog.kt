package com.example.todoapplication.views.body

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
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

        val calenderIcon: ImageButton= view.findViewById(R.id.calender_icon_add)
        val alarmIcon: ImageButton= view.findViewById(R.id.alarm_icon_add)
        val dateText:TextView = view.findViewById(R.id.add_date_textview)
        val timeText:TextView = view.findViewById(R.id.add_time_textview)

        val addButton: Button = view.findViewById(R.id.add_button)
        val cancelButton: Button = view.findViewById(R.id.cancel_add_button)
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())





        calenderIcon.setOnClickListener {

            //getting current day,month and year.
            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val month: Int = calendar.get(Calendar.MONTH)
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)


            // create date picker dialog and put the test into date EditText
            val dpd = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                dateText.setText("" + day + "/" + month + "/" + year)
            }, year, month, day)
            dpd.show() }

        alarmIcon.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                timeText.setText( SimpleDateFormat("HH:mm").format(calendar.time))
            }
            TimePickerDialog(view.context, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), false).show()
        }

        // add task to the recyclerview
        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val dueDate = dateText.text.toString()
            val duetime = timeText.text.toString()


            if (title.isNotEmpty() && description.isNotEmpty()) {

                taskViewModel.addTask(title,description, currentDate,dueDate,duetime)
                Toast.makeText(activity, "New task added ", Toast.LENGTH_LONG).show()

                // close dialog fragment
                getDialog()?.dismiss()

            } else
                Toast.makeText(context, "all field must be filled", Toast.LENGTH_LONG).show()

        }
        // end


        cancelButton.setOnClickListener {
            // close dialog
            getDialog()?.dismiss()
        }
    }

}
