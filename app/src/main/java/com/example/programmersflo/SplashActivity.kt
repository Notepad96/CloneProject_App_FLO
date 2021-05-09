package com.example.programmersflo

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.permmision_intro.view.*

class SplashActivity : AppCompatActivity() {
    val PERMISSIONCODE = 111
    private val DELAY_TIME = 1500L


    val requestPermissionms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_OWN_CALLS
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var rejectedPermissionList = ArrayList<String>()

        for(permission in requestPermissionms) {
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                rejectedPermissionList.add(permission)
            }
        }

        if(rejectedPermissionList.isNotEmpty()) {
            customDialog()
            val arr = arrayOfNulls<String>(rejectedPermissionList.size)
            ActivityCompat.requestPermissions(this, rejectedPermissionList.toArray(arr), PERMISSIONCODE)
        } else {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }



    fun customDialog() {
        val myLayout = layoutInflater.inflate(R.layout.permmision_intro, null)
        val build = AlertDialog.Builder(baseContext).apply {
            setView(myLayout)
        }
        val dialog = build.create()
        dialog.show()

        myLayout.btnPerOK.setOnClickListener {
            dialog.dismiss()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            PERMISSIONCODE -> {
                if (grantResults.isNotEmpty()) {
                    for ((i, permission) in permissions.withIndex()) {

                        if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                            Log.d("Msg", "$permission Denied")
                            customDialog()
                        }
                    }
                }
                else {
                    Handler().postDelayed( {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } , DELAY_TIME)
                }
            }
        }
    }

}