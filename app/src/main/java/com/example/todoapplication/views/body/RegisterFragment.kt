package com.example.todoapplication.views.body

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R

class RegisterFragment : Fragment() {
   lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fullnameEditText: EditText = view.findViewById(R.id.full_name_edittext)
        val emailEdittext: EditText = view.findViewById(R.id.email_edittext)
        val passwordEditText: EditText = view.findViewById(R.id.passwordLogin_edittext)

    }

}