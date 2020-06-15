package com.example.ftodokt.data

import java.util.*

/**
 * 封装更新todo所需参数
 *
 * @author fengzhaohao
 * @date 2020/6/15
 */
data class AddTodoData(
    var title: String,
    var content: String,
    var date: String, // 格式为: year-month-day
    var type: Int,
    var priority: Int
)