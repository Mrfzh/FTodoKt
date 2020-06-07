package com.example.ftodokt.utils

import android.app.Activity
import android.os.Build
import android.view.View

/**
 * 基础工具类
 *
 * @author fengzhaohao
 * @date 2020/6/4
 */
object CommonUtil {
    /**
     * 设置浅色状态栏（黑色字体和图标）
     */
    fun setLightColorStatusBar(activity: Activity) {
        // 6.0 以上版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor = activity.window.decorView
            decor.systemUiVisibility = (decor.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        }
    }

    /**
     * 设置深色状态栏（白色字体和图标）
     */
    fun setDarkColorStatusBar(activity: Activity) {
        // 6.0 以上版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decor = activity.window.decorView
            decor.systemUiVisibility = (decor.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv())
        }
    }
}