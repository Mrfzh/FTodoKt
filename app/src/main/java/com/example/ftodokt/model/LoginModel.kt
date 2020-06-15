package com.example.ftodokt.model

import com.example.ftodokt.net.OkhttpResponse
import com.example.ftodokt.net.OkhttpUtil
import com.example.ftodokt.net.RequestListener
import com.example.ftodokt.net.UrlProvider
import okhttp3.FormBody
import java.io.IOException

/**
 * 登录页面Model
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
class LoginModel {

    fun login(userName : String?, password : String?, requestListener: RequestListener) {
        val formBody = FormBody.Builder()
            .add("username", userName.toString())
            .add("password", password.toString())
            .build()
        OkhttpUtil.post(UrlProvider.login(), formBody, object : OkhttpResponse {
            override fun onResponse(json: String) {
                requestListener.requestSuccess(json)
            }

            override fun onFailure(exception: IOException) {
                requestListener.requestError(exception.message ?: "")
            }

        })
    }
}