package com.example.ftodokt.view

import android.content.Intent
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ftodokt.R
import com.example.ftodokt.base.BaseActivity
import com.example.ftodokt.databinding.ActivityLoginBinding
import com.example.ftodokt.test.TestActivity
import com.example.ftodokt.utils.CommonUtil
import com.example.ftodokt.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() , View.OnClickListener{

    // 创建ViewModel
    private val loginVM by lazy { ViewModelProviders.of(this).get(LoginViewModel::class.java) }

    override fun isHideTitleBar(): Boolean {
        return true
    }

    override fun initData() {
        // 设置状态栏颜色
        CommonUtil.setDarkColorStatusBar(this)
        window.statusBarColor = resources.getColor(R.color.main_color)

        // 创建DataBinding
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )
        // 绑定数据源
        binding.loginVM = loginVM

        // 监听EditText文字变化
        loginVM.username.observe(this, Observer { checkInputChanged() })
        loginVM.password.observe(this, Observer { checkInputChanged() })

        // toast提示
        loginVM.toastMsg.observe(this, Observer { showShortToast(loginVM.toastMsg.value) })

        // 登录状态
        loginVM.loginStatus.observe(this, Observer {
            if (loginVM.loginStatus.value == 0) {
                // 登录成功
                val intent = Intent(MainActivity.ACTION_LOGIN)
                intent.putExtra(MainActivity.EXTRA_USERNAME, loginVM.username.value)
                intent.putExtra(MainActivity.EXTRA_PASSWORD, loginVM.password.value)
                sendBroadcast(intent)
                finish()
            }
        })
    }

    override fun initView() {
        iv_login_back.setOnClickListener(this)
        tv_login_login.setOnClickListener(this)
        tv_login_register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_login_back -> {
                finish()
            }
            R.id.tv_login_register -> {
                showShortToast("register")
            }
            R.id.tv_login_login -> {
                if (!tv_login_login.isSelected) {
                    return
                }
                // 进行登录
                loginVM.login()
                CommonUtil.hideSoftInput(this)
            }
        }
    }

    private fun checkInputChanged() {
        if (loginVM.username.value == "" || loginVM.password.value == "") {
            tv_login_login.isSelected = false
            tv_login_login.setTextColor(resources.getColor(R.color.input_bar_button_text))
        } else {
            tv_login_login.isSelected = true
            tv_login_login.setTextColor(resources.getColor(R.color.input_bar_button_selected_text))
        }
    }

}
