package com.example.ftodokt.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ftodokt.R;

public class TestActivity extends AppCompatActivity {

    public static final String TEST_KEY = "test_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
