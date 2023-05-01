package com.example.a5month_hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.a5month_hw2.databinding.ItemSheepBinding

class SheepAdapter(
    private val list: ArrayList<Sheep>,
    private val addImage: (item: Sheep) -> Unit,
    private val removeImage: (item: Sheep) -> Unit,
    private val btnVisible: (sheep: Sheep) -> Unit
) :
    Adapter<SheepAdapter.ViewHolder>() {

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
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemSheepBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sheep: Sheep) {
            binding.ivSheep.loadImage(sheep.image)

            itemView.setOnClickListener {
                sheep.isSelected = !sheep.isSelected

                if (sheep.isSelected) {
                    binding.ivSheep.alpha = 0.3f
                    addImage(sheep)
                    btnVisible(sheep)
                } else {
                    removeImage(sheep)
                    binding.ivSheep.alpha = 1.0f
                }

            }
        }
    }
}