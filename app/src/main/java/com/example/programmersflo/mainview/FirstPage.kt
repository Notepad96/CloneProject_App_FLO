package com.example.programmersflo.mainview

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.programmersflo.R
import com.example.programmersflo.RecycleAdapter
import kotlinx.android.synthetic.main.fragment_first_page.*
import kotlinx.android.synthetic.main.fragment_first_page.view.*

class FirstPage : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view  = inflater.inflate(R.layout.fragment_first_page, container, false)

        viewManager = LinearLayoutManager(requireContext())
        viewManager.orientation = LinearLayout.HORIZONTAL
        viewAdapter = RecycleAdapter()

        recyclerView = view.recycleTest.apply {
            setHasFixedSize(true)
            layoutManager= viewManager
            adapter = viewAdapter
        }

        return view
    }

}