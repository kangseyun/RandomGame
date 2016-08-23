package com.seyun.healthtrainer.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.seyun.healthtrainer.Adapter.SelectMemeberAdapter;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

public class MemberSelectActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button insert, save, start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_select);
        init();
    }

    private void init() {
        layoutBind();
        recyclerViewBind();
    }

    private void layoutBind() {
        insert = (Button) findViewById(R.id.select_member_btn_insert);
        save = (Button) findViewById(R.id.select_member_btn_save);
        start = (Button) findViewById(R.id.select_member_btn_start);

        insert.setOnClickListener(this);
        save.setOnClickListener(this);
        start.setOnClickListener(this);
    }

    private void recyclerViewBind() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.member_select_rv);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new SelectMemeberAdapter(getUserInformation(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<SelectMemberModel> getUserInformation() {

        List<SelectMemberModel> userList = new ArrayList<>();
        userList.add(new SelectMemberModel(true, "강세윤"));
        userList.add(new SelectMemberModel(true, "김대준"));
        userList.add(new SelectMemberModel(true, "박주찬"));
        userList.add(new SelectMemberModel(true, "이재일"));

        return userList;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.select_member_btn_start:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.select_member_btn_save:
                break;
            case R.id.select_member_btn_insert:
                break;
            default:
                break;
        }

    }
}
