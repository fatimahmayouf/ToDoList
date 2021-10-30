package com.example.todoapplication.apphead

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todoapplication.R


class Main1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val logo: ImageView = view.findViewById(R.id.Logo_img)
        var timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {

     logo.animate().apply {

         /***
          * back to fix
          */
         rotation(360f)
    duration = 800
    rotationXBy(90f)
    rotationXBy(-90f)
}
            }

            override fun onFinish() {
              findNavController().navigate(R.id.action_main1Fragment_to_bodyFragment2)
            }
        }
        timer.start()
    }
}