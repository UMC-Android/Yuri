package com.example.umc_study09.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.umc_study09.R
import com.example.umc_study09.databinding.ActivityLoginInfoBinding
import com.kakao.sdk.user.UserApiClient

class LoginInfoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginInfoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_info)

        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(Constants.TAG, "사용자 정보 요청 실패 $error")
            } else if (user != null) {
                Log.d(Constants.TAG, "사용자 정보 요청 성공 : $user")
                binding.tvNickName.text = user.kakaoAccount?.profile?.nickname
                binding.tvAge.text = user.kakaoAccount?.ageRange.toString()
                binding.tvEmail.text = user.kakaoAccount?.email
            }
        }
    }
}