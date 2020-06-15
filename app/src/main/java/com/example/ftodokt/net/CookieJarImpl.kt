package com.example.ftodokt.net

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * 保存和提取cookies
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
class CookieJarImpl : CookieJar {

    var cookiesMap = HashMap<String, MutableList<Cookie>>()

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        cookiesMap[url.host()] = cookies
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return cookiesMap[url.host()] ?: mutableListOf()
    }
}