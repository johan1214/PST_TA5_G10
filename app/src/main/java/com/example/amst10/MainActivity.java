package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setTheme(R.style.Theme_AMST10);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
}