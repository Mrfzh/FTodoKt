package com.example.ftodokt.view

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ftodokt.R
import com.example.ftodokt.base.BaseActivity
import com.example.ftodokt.databinding.ActivityLoginBinding
import com.example.ftodokt.utils.CommonUtil
import com.example.ftodokt.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() , View.OnClickListener{

    // 创建 ViewModel
    private val loginVM by lazy { ViewModelProviders.of(this).get(LoginViewModel::class.java) }

    override fun isHideTitleBar(): Boolean {
        return true
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        // 设置状态栏颜色
        CommonUtil.setDarkColorStatusBar(this)
        window.statusBarColor = resources.getColor(R.color.main_color)

        // 创建 DataBinding
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )
        // 绑定数据源
        binding.loginVM = loginVM

        loginVM.username.observe(this, Observer { checkInputChanged() })
        loginVM.password.observe(this, Observer { checkInputChanged() })
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
                showShortToast("login")
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
