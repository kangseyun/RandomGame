package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seyun.healthtrainer.Fragment.FirstFragment;
import com.seyun.healthtrainer.Model.FirstFragmentModel;
import com.seyun.healthtrainer.R;

import java.util.List;

public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.UserViewHolder>{

    private List<FirstFragmentModel> userList;
    private Context context;
    public AllUsersAdapter(List<FirstFragmentModel> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card, null);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        FirstFragmentModel user = userList.get(position);

        holder.text.setText(user.getEmailId());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        public UserViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.info_text);
        }
    }
}