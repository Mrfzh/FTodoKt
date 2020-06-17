package com.example.ftodokt.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ftodokt.R
import com.example.ftodokt.data.UserInfo
import com.example.ftodokt.utils.SpUtils
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btn_test_add_sp.setOnClickListener {
            val userInfo = UserInfo("fzh", "123")
            SpUtils.saveUserInfo(userInfo)
        }

        btn_test_get_sp.setOnClickListener {
            val userInfo = SpUtils.getUserInfo()
            Log.d("fzh", "userinfo = $userInfo")
        }

        btn_test_clear_sp.setOnClickListener {
            SpUtils.clearUserInfo()
        }
    }
}
