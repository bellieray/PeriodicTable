package com.example.periodictable.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.periodictable.R
import com.example.periodictable.databinding.CustomDialogBinding
import com.example.periodictable.databinding.EmptyItemLayoutBinding
import com.example.periodictable.databinding.PeriodicItemLayoutBinding
import com.example.periodictable.model.ElementsModel
import com.example.periodictable.viewHolder.EmptyViewHolder
import com.example.periodictable.viewHolder.PeriodicViewHolder


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Eray Belli       │
//│ ──────────────────────── │
//│ erybelli@gmail.com                 │            
//│ ──────────────────────── │
//│ 17.09.2021                  │
//└──────────────────────────┘    

class PeriodicRecyclerAdapter(val callback:((model:ElementsModel)->Unit)) : ListAdapter<ElementsModel, RecyclerView.ViewHolder>(object:DiffUtil.ItemCallback<ElementsModel>(){
    override fun areItemsTheSame(oldItem: ElementsModel, newItem: ElementsModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ElementsModel, newItem: ElementsModel): Boolean {
     return  oldItem.elementName == newItem.elementName
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
      lateinit var viewHolder : RecyclerView.ViewHolder
        when(viewType){
           1 -> viewHolder =   EmptyViewHolder(EmptyItemLayoutBinding.inflate(inflater,parent,false))
           2 -> viewHolder =   PeriodicViewHolder(PeriodicItemLayoutBinding.inflate(inflater,parent,false),callback)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = getItem(position)
        if(model != null){
            when(holder){
                is EmptyViewHolder -> {}
                is PeriodicViewHolder -> holder.bind(model)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).elementName.isEmpty()) 1 else 2
    }

}