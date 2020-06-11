package com.example.ftodokt.view

import android.widget.Button
import android.widget.Toast
import com.example.ftodokt.R
import com.example.ftodokt.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun isHideTitleBar(): Boolean {
        return true
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {

    }

    override fun initView() {
        val button = findViewById<Button>(R.id.btn_main_test)
        button.setOnClickListener {
            Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show()
        }
    }
}
