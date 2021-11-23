package com.example.periodictable.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.databinding.PeriodicItemLayoutBinding
import com.example.periodictable.model.ElementsModel

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 17.09.2021                  │
// └──────────────────────────┘    

class PeriodicViewHolder(val binding: PeriodicItemLayoutBinding, val callback: ((model: ElementsModel) -> Unit)) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ElementsModel) {
        binding.model = item
        binding.layout.setOnClickListener {
            callback(item)
        }
    }
}
