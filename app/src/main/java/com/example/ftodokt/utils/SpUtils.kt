package com.example.ftodokt.utils

import android.content.Context.MODE_PRIVATE
import com.example.ftodokt.app.App
import com.example.ftodokt.data.UserInfo

/**
 * SharedPreferences工具类
 *
 * @author fengzhaohao
 * @date 2020/6/17
 */
object SpUtils {

    // object常量
    private const val USER_INFO = "user_info"
    private const val KEY_USERNAME = "key_username"
    private const val KEY_PASSWORD = "key_password"

    private val context by lazy { App.getAppContext() }

    /**
     * 存储用户信息
     */
    fun saveUserInfo(userInfo: UserInfo) {
        val editor = context.getSharedPreferences(USER_INFO, MODE_PRIVATE).edit()
        editor.putString(KEY_USERNAME, userInfo.username)
        editor.putString(KEY_PASSWORD, userInfo.password)
        editor.apply()
    }

    /**
     * 得到用户信息
     */
    fun getUserInfo() : UserInfo {
        val sp = context.getSharedPreferences(USER_INFO, MODE_PRIVATE)
        val username = sp.getString(KEY_USERNAME, "") ?: ""
        val password = sp.getString(KEY_PASSWORD, "") ?: ""
        return UserInfo(username, password)
    }

    /**
     * 清除用户信息
     */
    fun clearUserInfo() {
        val editor = context.getSharedPreferences(USER_INFO, MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }

}