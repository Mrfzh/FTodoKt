package com.example.ftodokt.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager

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

    /**
     * 隐藏软键盘(只适用于Activity，不适用于Fragment)
     */
    fun hideSoftInput(activity: Activity) {
        val view = activity.currentFocus
        if (view != null) {
            val inputMethodManager =
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }
}