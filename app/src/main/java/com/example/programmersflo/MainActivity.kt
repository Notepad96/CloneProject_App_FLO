package com.example.programmersflo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.exit_toast_box.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    var preTime: Long = 0
    override fun onBackPressed() {
        val temp = System.currentTimeMillis()
        if(temp - preTime >= 2000L) {
            preTime = temp

            val customLayout = layoutInflater.inflate(R.layout.exit_toast_box, toastLayout)
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_SHORT
            toast.setGravity(Gravity.BOTTOM, 0, 200)
            toast.view = customLayout
            toast.show()
        } else {
            super.onBackPressed()
        }
    }
}