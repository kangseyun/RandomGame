package com.seyun.healthtrainer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.seyun.healthtrainer.Adapter.SelectMemeberAdapter;
import com.seyun.healthtrainer.Database.User;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MemberSelectActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private SelectMemeberAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button insert, save, start, load;
    private EditText name;
    private CoordinatorLayout layout;
    private User user;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_select);
        init();
    }

    private void init() {
        layoutBind();
        recyclerViewBind();
        toolbarBind();
    }

    private void layoutBind() {
        insert = (Button) findViewById(R.id.select_member_btn_insert);
        save = (Button) findViewById(R.id.select_member_btn_save);
        start = (Button) findViewById(R.id.select_member_btn_start);
        load = (Button) findViewById(R.id.select_member_btn_load);
        name = (EditText) findViewById(R.id.select_member_et_name);
        layout = (CoordinatorLayout) findViewById(R.id.select_member_layout);

        insert.setOnClickListener(this);
        save.setOnClickListener(this);
        start.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    private void toolbarBind() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("파티원 구성");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void recyclerViewBind() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.member_select_rv);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SelectMemeberAdapter(getUserInformation(), this);
        mRecyclerView.setAdapter(mAdapter);


    }

    private List<SelectMemberModel> getUserInformation() {

        List<SelectMemberModel> userList = new ArrayList<>();
        return userList;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.select_member_btn_start:
                clickStartBtn();
                break;
            case R.id.select_member_btn_save:
                clickSaveBtn();
                break;
            case R.id.select_member_btn_load:
                clickLoadBtn();
                break;
            case R.id.select_member_btn_insert:
                clickInsertBtn();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void clickStartBtn(){
        new MaterialDialog.Builder(this)
                .title("파티이름 등록")
                .content("이번 파티이름을 등록해주세요")
                .negativeText(android.R.string.cancel)
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NULL)
                .input(null, "친구야술먹자", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        String name = input.toString();
                        Intent i = new Intent(MemberSelectActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .show();
    }

    private void clickSaveBtn() {
        new MaterialDialog.Builder(this)
                .title("즐겨찾기 추가")
                .content("즐겨찾기 이름을 입력해주세요. " +
                        "(현재인원을 동시에불러오실수있습니다.)")
                .negativeText(android.R.string.cancel)
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NULL)
                .input(null, null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, final CharSequence input) {
                    }
                })
                .show();
    }

    private void clickLoadBtn() {
        new MaterialDialog.Builder(this)
                .title("즐겨찾기 목록")
                .content("불러오실 즐겨찾기 항목을 체크해주세요")
                .negativeText(android.R.string.cancel)
                .positiveText(android.R.string.ok)
                .adapter(mAdapter, null)
                .show();
    }

    private void clickInsertBtn() {
        mAdapter.add(new SelectMemberModel(false, name.getText().toString()),0);
        name.setText(null);
    }
}
