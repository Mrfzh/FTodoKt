package com.example.ftodokt.viewmodel

import android.os.Handler
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ftodokt.data.LoginBean
import com.example.ftodokt.data.UserInfo
import com.example.ftodokt.model.LoginModel
import com.example.ftodokt.net.RequestListener
import com.example.ftodokt.utils.SpUtils
import com.google.gson.Gson

/**
 * 登录页面ViewModel
 *
 * @author fengzhaohao
 * @date 2020/6/10
 */
class LoginViewModel : ViewModel(){
    var username : MutableLiveData<String>  = MutableLiveData()
    var password : MutableLiveData<String>  = MutableLiveData()
    var toastMsg : MutableLiveData<String>  = MutableLiveData() // loginActivity显示的toast
    var loginStatus : MutableLiveData<Int>  = MutableLiveData() // 登录状态，成功 0，失败 1
    var showProgressBar : ObservableField<Boolean> = ObservableField()

    private val loginModel = LoginModel()
    
    /**
     * 进行登录操作
     */
    fun login() {
        showProgressBar.set(true)

        Handler().postDelayed({
            doLogin()
        }, 500)
    }

    fun doLogin() {
        val usernameStr = username.value?.trim()
        val passwordStr = password.value?.trim()

        loginModel.login(usernameStr, passwordStr, object : RequestListener {
            override fun requestSuccess(json: String) {
                // 解析json数据
                val gson = Gson()
                val loginBean : LoginBean = gson.fromJson(json, LoginBean::class.java)
                // 判断是否登录成功
                if (loginBean.errorCode == -1) {
                    // 下载失败
                    toastMsg.value = "账号不存在或密码错误"
                } else{
                    // 下载成功
                    loginStatus.value = 0
                    toastMsg.value = "登录成功"
                    // 保存用户信息到sp
                    SpUtils.saveUserInfo(UserInfo(usernameStr?:"", passwordStr?:""))
                }
                showProgressBar.set(false)
            }

            override fun requestError(errorMsg: String) {
                toastMsg.value = "请求异常"
                showProgressBar.set(false)
            }

        })
    }
}