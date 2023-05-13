package com.example.umc_study052

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_study052.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    private val todos = listOf(
        Todo("RecyclerView Item #1", false),
        Todo("RecyclerView Item #2", false),
        Todo("RecyclerView Item #3", false),
        Todo("RecyclerView Item #4", false),
        Todo("RecyclerView Item #5", false),
        Todo("RecyclerView Item #6", false),
        Todo("RecyclerView Item #7", false),
        Todo("RecyclerView Item #8", false),
        Todo("RecyclerView Item #9", false),
        Todo("RecyclerView Item #10", false),
        Todo("RecyclerView Item #11", false),
        Todo("RecyclerView Item #12", false),
        Todo("RecyclerView Item #13", false),
        Todo("RecyclerView Item #14", false),
        Todo("RecyclerView Item #15", false),
        Todo("RecyclerView Item #16", false),
        Todo("RecyclerView Item #17", false),
        Todo("RecyclerView Item #18", false),
        Todo("RecyclerView Item #19", false),
        Todo("RecyclerView Item #20", false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        binding.todoList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.todoList.adapter = TodoAdapter(todos)
    }
}