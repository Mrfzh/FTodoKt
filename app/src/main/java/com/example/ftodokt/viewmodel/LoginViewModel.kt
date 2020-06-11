package com.example.ftodokt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 登录页面ViewModel
 *
 * @author fengzhaohao
 * @date 2020/6/10
 */
class LoginViewModel : ViewModel(){
    var username : MutableLiveData<String>  = MutableLiveData()
    var password : MutableLiveData<String>  = MutableLiveData()
}