package com.srikant.searchify.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.srikant.searchify.R
import com.srikant.searchify.model.WebSearch

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var myList = emptyList<WebSearch>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)
        val url = itemView.findViewById<TextView>(R.id.url)
        val desc = itemView.findViewById<TextView>(R.id.desc)
        val lang = itemView.findViewById<TextView>(R.id.language)
        val publishedDate = itemView.findViewById<TextView>(R.id.publishDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.web_search, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = myList[position].data[position].title
        holder.url.text = myList[position].data[position].displayed_link
        holder.desc.text = myList[position].data[position].rank.toString()
        holder.lang.text = myList[position].data[position].source
        //holder.publishedDate.text = myList[position].value[position].datePublished
//        Glide.with(holder.itemView.context).load(myList[position].data[position].url)
//            .placeholder(R.drawable.ic_place_holder).into(holder.image)
    }

    fun setData(newList: List<WebSearch>) {
        myList = newList
        notifyDataSetChanged()
    }
}