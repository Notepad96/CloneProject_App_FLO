package com.example.programmersflo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_for_page.*

class ForPage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout: View = inflater.inflate(R.layout.fragment_for_page, container, false)

        val tb = (activity as MainActivity).supportActionBar
        (activity as MainActivity).setSupportActionBar(toolbar)
        if(tb != null) tb?.setDisplayHomeAsUpEnabled(false)

        return layout
    }

}