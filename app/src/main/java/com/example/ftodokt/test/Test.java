package com.example.ftodokt.test;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.example.ftodokt.view.MainActivity;

/**
 * 测试类，编写java代码
 *
 * @author fengzhaohao
 * @date 2020/6/12
 */
public class Test {

    public static final String ACTION_LOGIN = "action_login";

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

        Intent intent = new Intent(TestActivity.TEST_KEY);
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
