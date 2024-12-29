package com.example.recyclerviewclicklistener

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClothingAdapter(private val clothingList: List<ClothingItem>, private val context: Context) :
    RecyclerView.Adapter<ClothingAdapter.ClothingViewHolder>() {

    class ClothingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleView: TextView = itemView.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_clothing, parent, false)
        return ClothingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClothingViewHolder, position: Int) {
        val item = clothingList[position]
        holder.imageView.setImageResource(item.image)
        holder.titleView.text = item.title

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ClothingDetailActivity::class.java)
            intent.putExtra("CLOTHING_ITEM", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = clothingList.size
}