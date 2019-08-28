package com.example.latihan1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

//        val name = view.findViewById<TextView>(R.id.tv_name)
//        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindItem(
            items: Item,
            listener: (Item) -> Unit
        ) {
//            name.text = items.name
//            Glide.with(itemView.context).load(items.image).into(image)
//            itemView.setOnClickListener { listener(items) }
            itemView.tv_name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)
            itemView.setOnClickListener { listener(items) }
        }

    }
}