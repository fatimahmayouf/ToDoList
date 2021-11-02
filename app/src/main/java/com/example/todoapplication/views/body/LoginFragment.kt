package com.example.todoapplication.views.body

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R


class LoginFragment : Fragment() {
    lateinit var viewModel: TaskViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: Button = view.findViewById(R.id.login_button)
        val emailLoginEditText: EditText = view.findViewById(R.id.emailLoginEdittext)
        val passwordLoginEditText: EditText = view.findViewById(R.id.passwordLogin_edittext)


        //buttom
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
        loginButton.setOnClickListener {

            // get input then if login else message
            viewModel = TaskViewModel()
           var email = emailLoginEditText.text.toString()
           var password = passwordLoginEditText.text.toString()

         /* var userModel= viewModel.userLogin(email,password)

           // Log.d("userModel", userModel.toString())

           // if(userModel == null){
                Toast.makeText(activity, " not logged in  ", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(activity, "logged in ", Toast.LENGTH_LONG).show()
            }


          */
        }

    }

}