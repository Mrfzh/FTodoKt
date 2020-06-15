package com.example.ftodokt.test;

import android.os.Handler;
import android.os.Looper;

/**
 * 测试类，编写java代码
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
public class Test {

    private void m() {
        m1(new Listener() {
            @Override
            public void m1() {

            }
        });

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    interface Listener {
        void m1();
    }

    private void m1(Listener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);
    }

}
