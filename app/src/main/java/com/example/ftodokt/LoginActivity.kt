package com.example.ftodokt

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.ftodokt.base.BaseActivity
import com.example.ftodokt.utils.CommonUtil


class LoginActivity : BaseActivity() , View.OnClickListener{

    private lateinit var mBackIv : ImageView
    private lateinit var mUserNameEt : EditText
    private lateinit var mPassWordEt : EditText
    private lateinit var mRegisterTv : TextView
    private lateinit var mLoginTv : TextView

    private var mUserName : String = ""
    private var mPassWord : String = ""

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
    }

    override fun initView() {
        mBackIv = findViewById(R.id.iv_login_back)
        mBackIv.setOnClickListener(this)

        mUserNameEt = findViewById(R.id.et_login_username)
        mPassWordEt = findViewById(R.id.et_login_password)

        mUserNameEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mUserName = s.toString().trim()
                checkInputChanged()
            }

        })

        mPassWordEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mPassWord = s.toString().trim()
                checkInputChanged()
            }

        })

        mRegisterTv = findViewById(R.id.tv_login_register_tip)
        mRegisterTv.setOnClickListener(this)

        mLoginTv = findViewById(R.id.tv_login_login_button)
        mLoginTv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_login_back -> {
                showShortToast("back")
            }
            R.id.tv_login_register_tip -> {
                showShortToast("register")
            }
            R.id.tv_login_login_button -> {
                showShortToast("login")
            }
        }
    }

    private fun checkInputChanged() {
        if (mUserName == "" || mPassWord == "") {
            mLoginTv.isSelected = false
            mLoginTv.setTextColor(resources.getColor(R.color.input_bar_button_text))
        } else {
            mLoginTv.isSelected = true
            mLoginTv.setTextColor(resources.getColor(R.color.input_bar_button_selected_text))
        }
    }
}
