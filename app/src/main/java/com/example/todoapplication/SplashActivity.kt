package com.example.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.example.todoapplication.views.body.MainActivity

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar !!.hide()

        var intent = Intent(this, MainActivity :: class.java)


        val logo: ImageView = findViewById(R.id.Logo_img)
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

                startActivity(intent)

            }
        }
        timer.start()
    }
    }
