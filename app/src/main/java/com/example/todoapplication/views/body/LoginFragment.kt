package com.example.todoapplication.views.body

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R

class LoginFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val createAccount:TextView = view.findViewById(R.id.create_acount_txt)
        val forgetPassord: TextView = view.findViewById(R.id.forget_pass_txt)

        createAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            findNavController().popBackStack()
        }
         forgetPassord.setOnClickListener {
             findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
             //findNavController().popBackStack()
         }

    }

}