package com.example.todoapplication.views.body

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
        val update: TextView = view.findViewById(R.id.update_date_textview)
        val uptime: TextView = view.findViewById(R.id.update_time_textview)
        val calenderIcon: ImageButton = view.findViewById(R.id.calender_icon_update)
        val alarmIcon: ImageButton = view.findViewById(R.id.alarm_icon_update)

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        var toDayDate = sdf.format(Date())

        val cancel_update: Button = view.findViewById(R.id.cancel_update_button)
        val updateButton : Button = view.findViewById(R.id.update_button)



        //==================================================================================

        taskViewModel.selectedItemMutableLiveData.observe(viewLifecycleOwner,
            {

                Log.d("SELECTED_TASK" , it.toString())

                it?.let { item->

                    Log.d("SELECTED_TASK" , item.toString())
                    title.setText(item.Title)
                    Description.setText(item.Description)
                    date.setText(item.creationDate)
                    update.setText(item.taskdate)
                    uptime.setText(item.tasktime)


                    listTask = item

                }
            })

        //================================================================================

        calenderIcon.setOnClickListener{

            //getting current day,month and year.
            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val month1: Int = calendar.get(Calendar.MONTH)
            val month: Int = +month1
            val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

            // create date picker dialog and put the test into date EditText
            val dpd = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener {

                    view, year, month, day ->
                update.setText("" + day + "/" + (month.toInt()+1).toString()  + "/" + year)
            }, year, month, day)
            dpd.show()
        }
        //================================================================================

        alarmIcon.setOnClickListener{
            val calendar = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)
                uptime.setText( SimpleDateFormat("HH:mm").format(calendar.time))
            }
            TimePickerDialog(view.context, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), false).show()
        }

        //====================================================================================

        updateButton.setOnClickListener {
            var titlee = title.text.toString()
            var Descriptionn = Description.text.toString()
            var dayDate = toDayDate.toString()
            var updateDate = update.toString()
            var updateTime = uptime.toString()

            listTask.Title = titlee
            listTask.Description = Descriptionn
            listTask.creationDate = dayDate
            listTask.taskdate = updateDate
            listTask.tasktime = updateTime

            taskViewModel.updateTask(listTask)
            Toast.makeText(activity, "Task updated", Toast.LENGTH_SHORT).show()

            //close dialog fragment
            getDialog()?.dismiss()
        }


        cancel_update.setOnClickListener {
            // close dialog

            getDialog()?.dismiss()

        }
    }
}