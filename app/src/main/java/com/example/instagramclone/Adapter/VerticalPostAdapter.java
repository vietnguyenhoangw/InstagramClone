package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;

import java.util.ArrayList;

public class VerticalPostAdapter extends RecyclerView.Adapter<VerticalPostAdapter.VH>{

    Context context;
    ArrayList<String> data;

    public VerticalPostAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View converView = layoutInflater.inflate(R.layout.post_item, parent, false);

        return new VerticalPostAdapter.VH(converView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VH extends RecyclerView.ViewHolder{
        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
