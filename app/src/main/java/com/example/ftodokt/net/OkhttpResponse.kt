package com.example.ftodokt.net

import java.io.IOException

/**
 * okhttp请求结果
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
interface OkhttpResponse {
    fun onResponse(json: String)
    fun onFailure(exception : IOException)
}