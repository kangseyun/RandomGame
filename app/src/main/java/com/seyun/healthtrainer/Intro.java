package com.seyun.healthtrainer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seyun.healthtrainer.Activity.MainActivity;
import com.seyun.healthtrainer.Activity.MainMenuActivity;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                Intent intent = new Intent(Intro.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);
        Intent intent = new Intent(Intro.this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
