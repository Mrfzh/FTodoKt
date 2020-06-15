package com.example.ftodokt.net

/**
 * 请求后的回调，用于ViewModel和Model之间传递信息
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
interface RequestListener {
    fun requestSuccess(json : String)
    fun requestError(errorMsg : String)
}