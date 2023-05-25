package com.example.umc_study08

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_study08.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var memoAdapter: MemoAdapter
    private lateinit var memoList: MutableList<Memo>
    private lateinit var memoDatabase: MemoDatabase

    private val addMemoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val memoText = data?.getStringExtra("memo")
            if (memoText != null) {
                val newMemo = Memo(content = memoText)
                lifecycleScope.launch(Dispatchers.IO) {
                    memoDatabase.memoDao().insertMemo(newMemo)
                    loadMemos()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        memoDatabase = MemoDatabase.getInstance(this)
        memoList = mutableListOf()
        memoAdapter = MemoAdapter(memoList) { position ->
            deleteMemo(position)
        }

        binding.recyclerView.adapter = memoAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.addMemoButton.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            addMemoLauncher.launch(intent)
        }

        loadMemos()
    }

    private fun deleteMemo(position: Int) {
        val memo = memoList[position]
        lifecycleScope.launch(Dispatchers.IO) {
            memoDatabase.memoDao().deleteMemo(memo)
            loadMemos()
        }
    }

    private fun loadMemos() {
        lifecycleScope.launch(Dispatchers.IO) {
            val memos = memoDatabase.memoDao().getAllMemos()
            withContext(Dispatchers.Main) {
                memoList.clear()
                memoList.addAll(memos)
                memoAdapter.notifyDataSetChanged()
            }
        }
    }
}