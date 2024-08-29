package com.example.android_base_starter.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.android_base_starter.databinding.ListItemBinding
import com.example.android_base_starter.model.data.Item

class ItemAdapter(
    private val items: List<Item>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val vb: ListItemBinding): ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val vb = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ItemViewHolder(vb)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.vb.tvItem.text = item.name
        holder.vb.ivItem.load(item)
    }
}