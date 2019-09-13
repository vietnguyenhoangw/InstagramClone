package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.Objects.Story;
import com.example.instagramclone.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HorzizontalStoryAdapter extends RecyclerView.Adapter<HorzizontalStoryAdapter.VH>{

    Context context;
    ArrayList<Story> data;

    public HorzizontalStoryAdapter(Context context, ArrayList<Story> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View converView = layoutInflater.inflate(R.layout.story_item, parent, false);

        return new VH(converView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Story story = data.get(position);

        holder.userName.setText(story.getUserName());

        Picasso.get()
                .load(story.getUserProfileImage())
                .into(holder.userProfileImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class VH extends RecyclerView.ViewHolder{

        ImageView userProfileImage;
        TextView userName;

        public VH(@NonNull View itemView) {
            super(itemView);

            userProfileImage = itemView.findViewById(R.id.story_ImageUser);
            userName = itemView.findViewById(R.id.story_txtUserName);
        }
    }
}
