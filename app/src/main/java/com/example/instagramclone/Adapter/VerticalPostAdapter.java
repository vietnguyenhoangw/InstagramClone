package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.R;

import java.util.ArrayList;

public class VerticalPostAdapter extends RecyclerView.Adapter<VerticalPostAdapter.VH>{

    Context context;
    ArrayList<NewFeed> data;

    public VerticalPostAdapter(Context context, ArrayList<NewFeed> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View converView = layoutInflater.inflate(R.layout.post_item, parent, false);

        return new VH(converView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        NewFeed newFeed = data.get(position);

        holder.userName.setText(newFeed.getUserName());
        holder.like.setText(newFeed.getLike() + " Likes");
        holder.userPostName.setText(newFeed.getUserName());
        holder.caption.setText(newFeed.getCaption());
        holder.postTime.setText(newFeed.getPostTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView userName, like, userPostName, caption, postTime;

        public VH(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.post_txtUserName);
            like = itemView.findViewById(R.id.post_txtLike);
            userPostName = itemView.findViewById(R.id.post_txtName);
            caption = itemView.findViewById(R.id.post_txtCaption);
            postTime = itemView.findViewById(R.id.post_txtPostTime);
        }
    }
}
