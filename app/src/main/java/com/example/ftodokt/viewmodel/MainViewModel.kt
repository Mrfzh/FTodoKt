package com.example.ftodokt.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * 主页面ViewModel
 *
 * @author fengzhaohao
 * @date 2020/6/15
 */
class MainViewModel : ViewModel() {
    var username : ObservableField<String> = ObservableField()
    var title : ObservableField<String> = ObservableField()

    init {
        title.set("今天")
    }
}