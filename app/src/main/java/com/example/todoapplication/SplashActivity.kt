package com.example.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.example.todoapplication.Repository.TaskRepository
import com.example.todoapplication.views.body.MainActivity

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        TaskRepository.init(this)
        supportActionBar !!.hide()

        var intent = Intent(this, MainActivity :: class.java)


        val logo: ImageView = findViewById(R.id.Logo_img)
        var timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {

                logo.animate().apply {

                    /***
                     * back to fix
                     */
                    //rotation(90f)
                    duration = 700
                    rotationYBy(90f)
                }
            }

            override fun onFinish() {

                startActivity(intent)

            }
        }
        timer.start()
    }
    }
