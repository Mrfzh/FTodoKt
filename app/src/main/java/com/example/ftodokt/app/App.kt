package com.example.ftodokt.app

import android.app.Application
import android.content.Context

/**
 * 自定义Application
 *
 * @author fengzhaohao
 * @date 2020/6/17
 */
class App : Application() {

    companion object {
        lateinit var context : Context

        fun getAppContext() : Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}