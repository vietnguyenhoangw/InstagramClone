package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.VH>{

    Context context;
    ArrayList<String> storyData;
    ArrayList<String> postData;
    ArrayList<String> groupData;

    public GroupAdapter(Context context, ArrayList<String> storyData, ArrayList<String> postData, ArrayList<String> groupData) {
        this.context = context;
        this.storyData = storyData;
        this.postData = postData;
        this.groupData = groupData;
    }

    private void setList(RecyclerView recyclerView, int position) {
        switch (position) {
            case 0:
                setHorizontal(recyclerView);
                break;
            case 1:
                setVertical(recyclerView);
                break;
        }
    }

    private void setVertical(RecyclerView recyclerView) {
        VerticalPostAdapter verticalAdapter = new VerticalPostAdapter(context, storyData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(verticalAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }

    private void setHorizontal(RecyclerView recyclerView) {
        HorzizontalStoryAdapter hozitalAdapter = new HorzizontalStoryAdapter(context, postData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(hozitalAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        setList(holder.recyclerViewGroup, position);
    }

    @Override
    public int getItemCount() {
        return groupData.size();
    }

    class VH extends RecyclerView.ViewHolder{

        RecyclerView recyclerViewGroup;

        public VH(@NonNull View itemView) {
            super(itemView);

            recyclerViewGroup = itemView.findViewById(R.id.groupRecycleView);
        }
    }
}
