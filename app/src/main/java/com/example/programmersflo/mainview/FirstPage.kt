package com.example.programmersflo.mainview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.programmersflo.R
import com.example.programmersflo.RecycleAdapter

class FirstPage : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewManager = LinearLayoutManager(activity)
        viewAdapter = RecycleAdapter()

        recyclerView = recyclerView.apply {

        }

        return inflater.inflate(R.layout.fragment_first_page, container, false)
    }
}