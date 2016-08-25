package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.seyun.healthtrainer.Model.ContinueModel;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

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
    public void onBindViewHolder(UserViewHolder holder, int position) {
        SelectMemberModel user = userList.get(position);
        holder.check.setChecked(true);
        holder.name.setText(user.getName());
    }

    public void add(SelectMemberModel item, int position) {
        userList.add(position, item);
        notifyItemInserted(position);
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