package com.example.umc_study052

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_study052.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = generateItemList() // 아이템 리스트를 생성

        adapter = TodoAdapter(itemList)
        binding.todoList.adapter = adapter
        binding.todoList.layoutManager = LinearLayoutManager(this)

        adapter.notifyDataSetChanged() // 데이터 변경 시 어댑터에 알리기

    }

    private fun generateItemList(): List<Todo> {
        return listOf(
            Todo("Item 1", false),
            Todo("Item 2", true),
            Todo("Item 3", false),
            Todo("Item 4", false),
            Todo("Item 5", false),
            Todo("Item 6", false),
            Todo("Item 7", false),
            Todo("Item 8", false),
            Todo("Item 9", false),
            Todo("Item 10", false),
            Todo("Item 11", false),
            Todo("Item 12", false),
            Todo("Item 13", false),
            Todo("Item 14", false),
            Todo("Item 1", false),
            Todo("Item 2", true),
            Todo("Item 3", false),
            Todo("Item 4", false),
            Todo("Item 5", false),
            Todo("Item 6", false),
            Todo("Item 7", false),
            Todo("Item 8", false),
            Todo("Item 9", false),
            Todo("Item 10", false),
            Todo("Item 11", false),
            Todo("Item 12", false),
            Todo("Item 13", false),
            Todo("Item 14", false),
            )
    }
}
