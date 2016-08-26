package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.seyun.healthtrainer.Model.ContinueModel;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

import java.util.ArrayList;
import java.util.List;

public class SelectMemeberAdapter extends RecyclerView.Adapter<SelectMemeberAdapter.UserViewHolder>{

    private List<SelectMemberModel> userList;
    private Context context;
    public SelectMemeberAdapter(List<SelectMemberModel> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_member_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        final SelectMemberModel user = userList.get(position);
        holder.check.setChecked(true);
        holder.name.setText(user.getName());

        holder.check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                user.setCheck(user.getCheck());
            }
        });

    }

    public void add(SelectMemberModel item, int position) {
        userList.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<String> getUserList() {
        ArrayList<String> user = new ArrayList<>();
        for(int i=0;i<userList.size();i++) {
            if(userList.get(i).getCheck() == true)
                user.add(userList.get(i).getName());
        }
        return user;
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        CheckBox check;
        TextView name;
        public UserViewHolder(View itemView) {
            super(itemView);
            check = (CheckBox) itemView.findViewById(R.id.select_member_item_checkbox);
            name = (TextView) itemView.findViewById(R.id.select_member_item_name);
        }
    }
}