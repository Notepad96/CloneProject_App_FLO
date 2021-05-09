package com.example.programmersflo

import android.Manifest
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class SplashActivity : AppCompatActivity() {
    val PERMISSIONCODE = 111

    val requestPermissionms = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun cuDialog(context: Context) {
        val myLayout = layoutInflater.inflate(R.layout.custom_dialog, null)
        val build = AlertDialog.Builder(context).apply {
            setView(myLayout)
        }
        val dialog = build.create()
        dialog.show()

//        myLayout.okBtn.setOnClickListener {
//            dialog.dismiss()
//        }
    }
}