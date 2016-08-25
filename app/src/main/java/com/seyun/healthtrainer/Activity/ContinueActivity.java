package com.seyun.healthtrainer.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.seyun.healthtrainer.Adapter.ContinueAdapter;
import com.seyun.healthtrainer.Model.ContinueModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

public class ContinueActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ContinueAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        init();
    }

    private void init() {
        toolbarBind();
        recyclerViewBind();
    }

    private void toolbarBind() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("이어하기");
    }

    private void recyclerViewBind() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.continue_layout);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new ContinueAdapter(getUserInformation(), this);
        mRecyclerView.setAdapter(mAdapter);

    }


    private List<ContinueModel> getUserInformation() {

        List<ContinueModel> userList = new ArrayList<>();
        return userList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
