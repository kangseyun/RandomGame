package com.seyun.healthtrainer.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seyun.healthtrainer.Adapter.Fragment1Adapter;
import com.seyun.healthtrainer.Model.FirstFragmentModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvAllUsers);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new Fragment1Adapter(getUserInformation(), context);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }



    private List<FirstFragmentModel> getUserInformation() {

        List<FirstFragmentModel> userList = new ArrayList<>();
        userList.add(new FirstFragmentModel("베스킨라베스", R.drawable.ice));
        userList.add(new FirstFragmentModel("눈치게임", R.drawable.img1));
        userList.add(new FirstFragmentModel("제비뽑기", R.drawable.img2));
        userList.add(new FirstFragmentModel("사다리타기", R.drawable.img3));

        return userList;
    }


}

