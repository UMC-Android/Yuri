package com.example.umc_study09

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_study09.login.LoginActivity
import com.example.umc_study09.retrofit.Result
import com.example.umc_study09.retrofit.RetrofitClient
import com.example.umc_study09.retrofit.RetrofitInterface
import com.kakao.sdk.common.util.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>

    private lateinit var retrofitClient: RetrofitClient
    private lateinit var retrofitInterface: RetrofitInterface

    private val API_KEY = "d54e032602685f4948df226385442dbb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //login 먼저 실행
        val loginIntent = Intent(this, LoginActivity::class.java)
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(loginIntent)
        finish()

        //KakaoSdk받기
        Log.d(TAG, "keyhash : ${Utility.getKeyHash(this)}")

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        retrofitClient = RetrofitClient.getInstance()
        retrofitInterface = RetrofitClient.getRetrofitInterface()

        retrofitInterface.getBoxOffice(API_KEY, "20230601").enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val result = response.body()
                val boxOfficeResult = result?.boxOfficeResult
                Log.d("retrofit", "Data fetch success")
                mAdapter = MovieAdapter(boxOfficeResult?.dailyBoxOfficeList ?: emptyList())

                recyclerView.adapter = mAdapter
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("retrofit", t.message!!)
            }
        })
    }
}
