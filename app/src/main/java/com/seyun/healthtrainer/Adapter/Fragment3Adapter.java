package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seyun.healthtrainer.Model.Fragment3Model;
import com.seyun.healthtrainer.Model.SelectMemberModel;
import com.seyun.healthtrainer.R;

import java.util.List;

public class Fragment3Adapter extends RecyclerView.Adapter<Fragment3Adapter.UserViewHolder>{

    private List<Fragment3Model> userList;
    private Context context;
    public Fragment3Adapter(List<Fragment3Model> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Fragment3Model user = userList.get(position);
        holder.name.setText(user.getName());
        holder.sum1.setText(user.getSum1());
        holder.sum2.setText(user.getSum2());
    }

    public void add(Fragment3Model item, int position) {
        userList.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView sum1;
        TextView sum2;
        public UserViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.member_card_name);
            sum1 = (TextView) itemView.findViewById(R.id.sum1);
            sum2 = (TextView) itemView.findViewById(R.id.sum2);
        }
    }
}