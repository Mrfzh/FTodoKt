package com.example.ftodokt.base

import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity基类，规定所有Activity都要继承该类
 *
 * @author fengzhaohao
 * @date 2020/6/7
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isHideTitleBar()) {
            // 隐藏标题栏
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        }
        setContentView(getLayoutResId())

        initData()
        initView()
    }

    abstract fun isHideTitleBar() : Boolean

    abstract fun getLayoutResId() : Int

    abstract fun initData()

    abstract fun initView()

    protected fun showShortToast(content: String?) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}