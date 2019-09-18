package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class UserGridPostAdapter extends RecyclerView.Adapter<UserGridPostAdapter.VH> {

    Context context;
    ArrayList<NewFeed> data;

    public UserGridPostAdapter(Context context, ArrayList<NewFeed> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View convertView = layoutInflater.inflate(R.layout.grid_square_item, parent, false);

        return new VH(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        NewFeed newFeed = data.get(position);

        Picasso.get()
                .load(newFeed.getPostImage())
                .into(holder.postImage);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class VH extends  RecyclerView.ViewHolder {

        ImageView postImage;

        public VH(@NonNull View itemView) {
            super(itemView);

            postImage = itemView.findViewById(R.id.SquareGridItemImage);
        }
    }
}