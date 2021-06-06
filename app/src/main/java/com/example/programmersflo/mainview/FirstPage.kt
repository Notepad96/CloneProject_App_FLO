package com.example.programmersflo.mainview

import android.annotation.SuppressLint
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

    private var recyclerView: MutableList<RecyclerView> = mutableListOf()
    private var viewAdapter: MutableList<RecyclerView.Adapter<*>> = mutableListOf()
    private var viewManager: MutableList<LinearLayoutManager> = mutableListOf()

    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view  = inflater.inflate(R.layout.fragment_first_page, container, false)

        for(i in 0..2) {
            viewManager.add(LinearLayoutManager(requireContext()))
            viewManager[i].orientation = LinearLayout.HORIZONTAL
            viewAdapter.add(RecycleAdapter())

            var list = when(i) {
                0 -> view.smallList
                1 -> view.smallList2
                else -> view.smallList3
            }
            recyclerView.add(list)
            recyclerView[i].apply {
                setHasFixedSize(true)
                layoutManager = viewManager[i]
                adapter = viewAdapter[i]
            }
        }

        return view
    }

}