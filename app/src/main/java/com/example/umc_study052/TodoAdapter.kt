package com.example.umc_study052

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_study052.databinding.ListItemBinding
class TodoAdapter(private val itemList: List<Todo>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Todo) {
            binding.todoText.text = item.text
            binding.switch1.setOnCheckedChangeListener { _, isChecked ->
                item.isChecked = isChecked //값 변경 시 마다 isChecked 업데이트
            }
        }
    }
}