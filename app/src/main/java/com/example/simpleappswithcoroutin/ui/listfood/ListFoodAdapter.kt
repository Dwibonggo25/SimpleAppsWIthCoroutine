package com.example.simpleappswithcoroutin.ui.listfood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleappswithcoroutin.databinding.ItemListFoodBinding
import com.example.simpleappswithcoroutin.db.entity.Foods

class ListFoodAdapter  : ListAdapter <Foods, ListFoodAdapter.ViewHolder> (DiffCallback) {

    override fun onBindViewHolder (holder : ViewHolder, position: Int) = holder.bind (getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListFoodBinding.inflate(layoutInflater, parent, false)
        return ViewHolder (binding)
    }

    class ViewHolder(private val binding: ItemListFoodBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Foods) {
            binding.apply {
                foods = item
                binding.executePendingBindings()
            }
        }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Foods>() {
            override fun areItemsTheSame(oldItem: Foods, newItem: Foods): Boolean {
                return oldItem.foodsId == newItem.foodsId
            }

            override fun areContentsTheSame(oldItem: Foods, newItem: Foods): Boolean {
                return oldItem == newItem
            }
        }
    }

}