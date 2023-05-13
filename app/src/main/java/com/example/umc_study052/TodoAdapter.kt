package com.example.umc_study052

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_study052.databinding.ListItemBinding

class TodoAdapter(private val todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val binding =  ListItemBinding.inflate(
            LayoutInflater.from(parent.context), // layoutInflater 를 넘기기위해 함수 사용, ViewGroup 는 View 를 상속하고 View 는 이미 Context 를 가지고 있음
            parent, // 부모(리싸이클러뷰 = 뷰그룹)
            false   // 리싸이클러뷰가 attach 하도록 해야함 (우리가 하면 안됨)
        )
        return TodoViewHolder(binding).also { holder ->
            binding.switch1.setOnCheckedChangeListener { _, isChecked ->
                todos.getOrNull(holder.adapterPosition)?.completed = isChecked
            }
        }
    }

    // position = 리스트 상에서 몇번째인지 의미
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size

    class TodoViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            binding.todoTitleText.text = todo.title
            binding.switch1.isChecked = todo.completed
        }
    }
}