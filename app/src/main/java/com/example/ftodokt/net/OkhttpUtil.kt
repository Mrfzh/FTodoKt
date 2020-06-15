package com.example.ftodokt.net

import android.os.Handler
import android.os.Looper
import okhttp3.*
import java.io.IOException

/**
 * okhttp工具类，封装get、post等请求
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
object OkhttpUtil {
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .cookieJar(CookieJarImpl())
            .build()
    }

    /**
     * get请求
     */
    fun get(url : String, okhttpResponse: OkhttpResponse) {
        val request = Request.Builder()
            .url(url)
            .build()
        doRequest(request, okhttpResponse)
    }

    /**
     * post请求
     */
    fun post(url : String, formBody: FormBody, okhttpResponse: OkhttpResponse) {
        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()
        doRequest(request, okhttpResponse)
    }

    private fun doRequest(request : Request, okhttpResponse: OkhttpResponse) {
        val call = okHttpClient.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Handler(Looper.getMainLooper()).post {
                    okhttpResponse.onFailure(e)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body()?.string()
                Handler(Looper.getMainLooper()).post {
                    okhttpResponse.onResponse(json ?: "")
                }
            }
        })
    }
}