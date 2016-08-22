package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        FirstFragmentModel user = userList.get(position);
        holder.text.setText(user.getTitle());
        holder.img.setImageResource(user.getImg());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView img;
        public UserViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.info_text);
            img = (ImageView) itemView.findViewById(R.id.card_img);
        }
    }
}