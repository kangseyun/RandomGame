package com.seyun.healthtrainer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.seyun.healthtrainer.Database.Bookmark;
import com.seyun.healthtrainer.Model.BookMarkModel;
import com.seyun.healthtrainer.R;

import java.util.List;

import io.realm.RealmResults;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.UserViewHolder>{

    private List<BookMarkModel> userList;
    private Context context;
    public BookmarkAdapter(List<BookMarkModel> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookbmark_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        BookMarkModel user = userList.get(position);
        holder.check.setChecked(false);
        holder.name.setText(user.getName());
    }

    public void add(BookMarkModel item, int position) {
        userList.add(position, item);
        notifyItemInserted(position);
    }
    public void dataLoad(RealmResults<Bookmark> result) {
        userList.clear();
        for(int i=0;i<result.size();i++) {
            userList.add(new BookMarkModel(false, result.get(i).getTitle()));
        }
        notifyDataSetChanged();
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
            check = (CheckBox) itemView.findViewById(R.id.bookmark_checkbox);
            name = (TextView) itemView.findViewById(R.id.bookmark_name);
        }
    }
}