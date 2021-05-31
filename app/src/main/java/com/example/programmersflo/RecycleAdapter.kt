package com.example.programmersflo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_small.view.*

class RecycleAdapter : RecyclerView.Adapter<RecycleAdapter.MyViewHolder>() {
    var imgList = listOf<Int>( R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5 )
    var textList = listOf<String>( "\'시간\'을 사고팔 수 있다면", "시간을 파는 상점2", "미드나잇 라이브러리", "타임머신과 과학좀 하는 로봇", "가나다라마바사아자차카타파하")

    class MyViewHolder(val layout: View) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_small, parent, false)

        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layout.list_image_item.setBackgroundResource(imgList[position])
        holder.layout.list_text_item.text = textList[position]
    }

    override fun getItemCount(): Int {
        return imgList.size
    }
}
