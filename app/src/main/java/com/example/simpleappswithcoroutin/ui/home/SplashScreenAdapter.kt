package com.example.simpleappswithcoroutin.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleappswithcoroutin.databinding.RvItemDetailJsonBinding
import com.example.simpleappswithcoroutin.model.Todo

class SplashScreenAdapter (private val context: Context, private val viewModel : HomeViewmodel) : ListAdapter<Todo, SplashScreenAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  RvItemDetailJsonBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: RvItemDetailJsonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Todo, context : Context, viewModel: HomeViewmodel) {
            binding.tvTitle.setText(model.title)
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position), context, viewModel)

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }

}
