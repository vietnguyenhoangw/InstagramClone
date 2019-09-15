package com.example.instagramclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.Objects.Category;
import com.example.instagramclone.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.VH> {

    Context context;
    ArrayList<Category> categoryData;

    public CategoriesAdapter(Context context, ArrayList<Category> categoryData) {
        this.context = context;
        this.categoryData = categoryData;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View converView = layoutInflater.inflate(R.layout.categories_search_item, parent, false);

        return new VH(converView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Category category = categoryData.get(position);

        holder.search_categories.setText(category.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryData.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        TextView search_categories;

        public VH(@NonNull View itemView) {
            super(itemView);

            search_categories = itemView.findViewById(R.id.search_categories);
        }
    }
}
