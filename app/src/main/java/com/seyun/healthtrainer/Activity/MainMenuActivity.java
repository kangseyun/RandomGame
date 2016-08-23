package com.seyun.healthtrainer.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.seyun.healthtrainer.R;



public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startBtn, continueBtn, settingBtn, exitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        init();
    }

    void init() {
        bind();
    }

    void bind() {
        startBtn = (Button) findViewById(R.id.MainMenuButton_start);
        continueBtn = (Button) findViewById(R.id.MainMenuButton_continue);
        settingBtn = (Button) findViewById(R.id.MainMenuButton_setting);
        exitBtn = (Button) findViewById(R.id.MainMenuButton_exit);

        startBtn.setOnClickListener(this);
        continueBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent i = null;
        switch (id) {
            case R.id.MainMenuButton_start:
                i = new Intent(this, MemberSelectActivity.class);
                break;
            case R.id.MainMenuButton_continue:
                i = new Intent(this, MainActivity.class);
                break;
            case R.id.MainMenuButton_setting:
                i = new Intent(this, MainActivity.class);
                break;
            case R.id.MainMenuButton_exit:
                i = new Intent(this, MainActivity.class);
                break;
        }
        startActivity(i);
    }
}
