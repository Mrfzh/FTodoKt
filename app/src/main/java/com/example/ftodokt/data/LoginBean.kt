package com.example.ftodokt.data

/**
 * login api返回的json数据对应的实体类
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
data class LoginBean(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val admin: Boolean,
    val chapterTops: List<Any>,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)