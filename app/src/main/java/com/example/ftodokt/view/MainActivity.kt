package com.example.ftodokt.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ftodokt.R
import com.example.ftodokt.base.BaseActivity
import com.example.ftodokt.databinding.ActivityMainBinding
import com.example.ftodokt.utils.CommonUtil
import com.example.ftodokt.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener{

    // 常量
    companion object {
        const val ACTION_LOGIN = "action_login"
        const val EXTRA_USERNAME = "extra_username"
    }

    private val mainVM by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    private val loginReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // 登录成功
            val username = intent?.getStringExtra(EXTRA_USERNAME)
            mainVM.username.set(username?:"")
        }
    }

    override fun isHideTitleBar(): Boolean {
        return true
    }

    override fun initData() {
        // 设置状态栏颜色
        CommonUtil.setDarkColorStatusBar(this)
        window.statusBarColor = resources.getColor(R.color.main_color)

        // 绑定DataBinding
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.mainVM = mainVM

        // 注册广播，接收登录信息
        registerReceiver(loginReceiver, IntentFilter(ACTION_LOGIN))
    }

    override fun initView() {
        iv_main_add_todo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.iv_main_add_todo -> {
                startActivity(LoginActivity::class.java)
            }
        }
    }
}
