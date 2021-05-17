package com.example.programmersflo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.exit_toast_box.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainNavigationView.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().replace(R.id.mainLayout, FirstPage()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, FirstPage()).commit()
            }
            R.id.menu_music -> {
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, SecPage()).commit()
            }
            R.id.menu_search -> {
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, TrdPage()).commit()
            }
            R.id.menu_user -> {
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, ForPage()).commit()
            }
        }
        return true
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