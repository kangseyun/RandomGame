package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.seyun.healthtrainer.Model.FirstFragmentModel;
import com.seyun.healthtrainer.Model.Fragment3Model;
import com.seyun.healthtrainer.R;

import java.util.List;

public class Fragment1Adapter extends RecyclerView.Adapter<Fragment1Adapter.UserViewHolder>{

    private List<FirstFragmentModel> userList;
    private Context context;
    public Fragment1Adapter(List<FirstFragmentModel> userList, Context context) {
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

    public void add(FirstFragmentModel item, int position) {
        userList.add(position, item);
        notifyItemInserted(position);
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView text;
        private ImageView img;
        private Button setting;
        public UserViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.info_text);
            img = (ImageView) itemView.findViewById(R.id.card_img);
            setting = (Button) itemView.findViewById(R.id.card_btn_setting);
            setting.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id = view.getId();
            Log.i("123", text.getText().toString());
        }
    }
}