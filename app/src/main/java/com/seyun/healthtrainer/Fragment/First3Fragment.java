package com.seyun.healthtrainer.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seyun.healthtrainer.Adapter.Fragment3Adapter;
import com.seyun.healthtrainer.Model.Fragment3Model;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

public class First3Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first3, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment3);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new Fragment3Adapter(getUserInformation(), context);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private List<Fragment3Model> getUserInformation() {

        List<Fragment3Model> userList = new ArrayList<>();
        userList.add(new Fragment3Model("강세윤", "나온금액 :10000", "지불금액: 10000"));
        userList.add(new Fragment3Model("박주찬", "나온금액 :25000", "지불금액: 10000"));
        userList.add(new Fragment3Model("김대준", "나온금액 :30000", "지불금액: 10000"));

        return userList;
    }
}