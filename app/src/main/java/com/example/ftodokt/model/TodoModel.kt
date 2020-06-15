package com.example.ftodokt.model

import com.example.ftodokt.data.AddTodoData
import com.example.ftodokt.net.OkhttpResponse
import com.example.ftodokt.net.OkhttpUtil
import com.example.ftodokt.net.RequestListener
import com.example.ftodokt.net.UrlProvider
import okhttp3.FormBody
import java.io.IOException

/**
 * todo相关操作
 *
 * @author fengzhaohao
 * @date 2020/6/15
 */
class TodoModel {
    /**
     * 添加一条todo
     */
    fun addTodo(addTodoData: AddTodoData, requestListener: RequestListener) {
        val formBody = FormBody.Builder()
            .add("title", addTodoData.title)
            .add("content", addTodoData.content)
            .add("date", addTodoData.date)
            .add("type", addTodoData.type.toString())
            .add("priority", addTodoData.priority.toString())
            .build()
        OkhttpUtil.post(UrlProvider.addTodo(), formBody, object : OkhttpResponse {
            override fun onResponse(json: String) {
                requestListener.requestSuccess(json)
            }

            override fun onFailure(exception: IOException) {
                requestListener.requestError(exception.message ?: "")
            }

        })
    }
}