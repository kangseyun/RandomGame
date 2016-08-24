package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seyun.healthtrainer.Model.ContinueModel;
import com.seyun.healthtrainer.R;

import java.util.List;

public class ContinueAdapter extends RecyclerView.Adapter<ContinueAdapter.UserViewHolder>{

    private List<ContinueModel> userList;
    private Context context;

    public ContinueAdapter(List<ContinueModel> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.continu_card, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        ContinueModel user = userList.get(position);
        holder.title.setText(user.getTitle());
        holder.sum1.setText(user.getSum1());
        holder.sum2.setText(user.getSum2());
    }

    public void add(ContinueModel item, int position) {
        userList.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView sum1;
        TextView sum2;
        public UserViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.continue_title);
            sum1 = (TextView) itemView.findViewById(R.id.continue_sum1);
            sum2 = (TextView) itemView.findViewById(R.id.continue_sum2);
        }
    }
}