package com.example.start;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.LayoutHolder> {
    private List<layoutTableDB> layouts = new ArrayList<>();

    @NonNull
    @Override
    public LayoutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_choose_layout, parent, false);
        return new LayoutHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutHolder holder, int position) {
        layoutTableDB currentLayout = layouts.get(position);
        holder.textViewTitle.setText(currentLayout.getLayout_name());

    }

    @Override
    public int getItemCount() {
        return layouts.size();
    }

    public void setLayouts(List<layoutTableDB> layouts) {
        this.layouts = layouts;
        notifyDataSetChanged();
    }

    class LayoutHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;


        public LayoutHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);

        }
    }
}