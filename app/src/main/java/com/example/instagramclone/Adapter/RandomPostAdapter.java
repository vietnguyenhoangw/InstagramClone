package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.Objects.NewFeed;
import com.example.instagramclone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RandomPostAdapter extends RecyclerView.Adapter<RandomPostAdapter.VH> {

    Context context;
    ArrayList<NewFeed> randomPostData;

    public RandomPostAdapter(Context context, ArrayList<NewFeed> randomPostData) {
        this.context = context;
        this.randomPostData = randomPostData;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View convertView = layoutInflater.inflate(R.layout.randompost_search_item,
        parent, false);

        return new VH(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        NewFeed newFeed = randomPostData.get(position);

        Picasso.get()
                .load(newFeed.getPostImage())
                .into(holder.randomPostImage);
    }

    @Override
    public int getItemCount() {
        return randomPostData.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView randomPostImage;

        public VH(@NonNull View itemView) {
            super(itemView);

            randomPostImage = itemView.findViewById(R.id.search_randompostImage);
        }
    }
}
