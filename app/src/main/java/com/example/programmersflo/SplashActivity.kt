package com.example.programmersflo

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.permmision_deny.view.*
import kotlinx.android.synthetic.main.permmision_intro.view.*
import kotlinx.android.synthetic.main.permmision_intro.view.btnPerOK

class SplashActivity : AppCompatActivity() {
    val PERMISSIONCODE = 111
    private val DELAY_TIME = 1500L

    val requestPermissionms = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_CONTACTS
    )
    var rejectedPermissionList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        for(permission in requestPermissionms) {
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                rejectedPermissionList.add(permission)
            }
        }

        if(rejectedPermissionList.size != 0) {
            introDialog(R.layout.permmision_intro)
        } else {
            splashView()
        }

    }

    private fun splashView() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, DELAY_TIME)
    }

    fun introDialog(layout_id: Int) {
        val myLayout = layoutInflater.inflate(layout_id, null)

        val build = AlertDialog.Builder(this).apply {
            setView(myLayout)
        }
        val dialog = build.create()
        dialog.show()

        if(layout_id == R.layout.permmision_intro) {
            myLayout.btnPerOK.setOnClickListener {
                dialog.dismiss()
                val arr = arrayOfNulls<String>(rejectedPermissionList.size)
                ActivityCompat.requestPermissions(this, rejectedPermissionList.toArray(arr), PERMISSIONCODE)
            }
        } else {
            myLayout.btnPerOK.setOnClickListener {
                finish()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            PERMISSIONCODE -> {
                if (grantResults.isNotEmpty()) {
                    for ((i, permission) in permissions.withIndex()) {
                        if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                            Log.d("Msg", "$permission Denied")
                            introDialog(R.layout.permmision_deny)
                        }
                    }
                    splashView()
                }
            }
        }
    }

}