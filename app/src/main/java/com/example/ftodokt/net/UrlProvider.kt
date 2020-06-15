package com.example.ftodokt.net

/**
 * 提供api接口
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
object UrlProvider {

    /**
     * 登录
     *
     * 方法：POST
     * 参数：
     * username：用户名
     * password：密码
     */
    fun login() : String {
        return "https://www.wanandroid.com/user/login"
    }

    /**
     * 新增一个todo
     *
     * 方法：POST
     * 参数：
     * title: 新增标题（必须）
     * content: 新增详情（必须）
     * date: 2018-08-01 预定完成时间（不传默认当天，建议传）
     * type: 大于0的整数（可选）；
     * priority 大于0的整数（可选）；
     */
    fun addTodo() : String{
        return "https://www.wanandroid.com/lg/todo/add/json"
    }
}