package com.seyun.healthtrainer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.seyun.healthtrainer.Adapter.BookmarkAdapter;
import com.seyun.healthtrainer.Adapter.SelectMemeberAdapter;
import com.seyun.healthtrainer.Database.Bookmark;
import com.seyun.healthtrainer.Database.Party;
import com.seyun.healthtrainer.Database.RealmString;
import com.seyun.healthtrainer.Database.User;
import com.seyun.healthtrainer.Model.BookMarkModel;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MemberSelectActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView, mRecyclerView2;
    private SelectMemeberAdapter mAdapter;
    private BookmarkAdapter mBookAdapter;
    private RecyclerView.LayoutManager mLayoutManager, mLayoutManager2;
    private Button insert, save, start, load;
    private EditText name;
    private CoordinatorLayout layout;
    private User user;
    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_select);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplication()).build();
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();
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
        mRecyclerView2 = (RecyclerView) this.findViewById(R.id.bookmark_layout);
        mRecyclerView2.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager2 = new LinearLayoutManager(this);

        mBookAdapter = new BookmarkAdapter(getUserInformation2(), this);
        mRecyclerView2.setAdapter(mBookAdapter);
        mAdapter = new SelectMemeberAdapter(getUserInformation(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<SelectMemberModel> getUserInformation() {

        List<SelectMemberModel> userList = new ArrayList<>();
        return userList;
    }

    private List<BookMarkModel> getUserInformation2() {

        List<BookMarkModel> userList = new ArrayList<>();
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
                        final String name = input.toString();
                        final ArrayList<String> list = mAdapter.getUserList();

                        if (list.size() == 0) { // 항목이 존재 하지 않을경우 실패처리
                            Snackbar.make(layout, "[실패] 항목이 하나 이상 존재해야합니다.", Snackbar.LENGTH_LONG).show();
                        } else {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    Party party = realm.createObject(Party.class);
                                    party.setTitle(name);
                                    for (int i = 0; i < list.size(); i++) {
                                        User obj = realm.createObject(User.class);
                                        obj.setName(list.get(i));
                                        party.name.add(obj);
                                    }
                                }
                            });

                            Intent i = new Intent(MemberSelectActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        }
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
                        final ArrayList<String> list = mAdapter.getUserList();
                        if (list.size() == 0) { // 항목이 존재 하지 않을경우 실패처리
                            Snackbar.make(layout, "[실패] 항목이 하나 이상 존재해야합니다.", Snackbar.LENGTH_LONG).show();
                        } else {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    Bookmark bookmark = realm.createObject(Bookmark.class);
                                    bookmark.setTitle(input.toString());
                                    for (int i = 0; i < list.size(); i++) {
                                        RealmString string = realm.createObject(RealmString.class);
                                        string.setName(list.get(i));
                                        bookmark.name.add(string);
                                    }
                                }
                            });
                            Snackbar.make(layout, "즐겨찾기 추가완료", Snackbar.LENGTH_LONG).show();
                        }
                    }
                })
                .show();
    }

    private void clickLoadBtn() {
        RealmResults<Bookmark> result = realm.where(Bookmark.class).findAll();
        mBookAdapter.dataLoad(result);
        new MaterialDialog.Builder(this)
                .title("즐겨찾기 목록")
                .content("불러오실 즐겨찾기 항목을 체크해주세요")
                .negativeText(android.R.string.cancel)
                .positiveText(android.R.string.ok)
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if(which.toString() == "POSITIVE"){
                           ArrayList<String> user =  mBookAdapter.userLoad();
                           for(String u : user){
                               RealmResults<Bookmark> uobj = realm.where(Bookmark.class).equalTo("title", u).findAll();
                               for(Bookmark b : uobj){
                                   for(RealmString t: b.name) {
                                       mAdapter.add(new SelectMemberModel(true, t.getName()),0);
                                   }
                               }
                           }
                        }
                    }
                })
                .adapter(mBookAdapter, null)
                .show();
    }

    private void clickInsertBtn() {
        mAdapter.add(new SelectMemberModel(true, name.getText().toString()),0);
        name.setText(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
