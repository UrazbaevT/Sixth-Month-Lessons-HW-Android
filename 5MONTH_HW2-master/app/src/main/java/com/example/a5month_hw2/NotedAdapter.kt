package com.example.a5month_hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.a5month_hw2.databinding.ItemSheepBinding

class NotedAdapter(val list: ArrayList<Sheep>) :
    Adapter<NotedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSheepBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val binding: ItemSheepBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = list[adapterPosition]
            binding.ivSheep.loadImage(item.image)
        }
    }

}