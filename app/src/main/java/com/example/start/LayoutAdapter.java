package com.example.start;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.LayoutHolder> {
    private List<layoutTableDB> layouts = new ArrayList<>();
    private OnItemClickListener listener;
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
    public layoutTableDB getNoteAt(int position) {
        return layouts.get(position);
    }
    class LayoutHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private Button button_delete ;

        public LayoutHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            button_delete = itemView.findViewById(R.id.deleteButton);
            button_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(layouts.get(position));
                    }
                }
            });
        }

    }
    public interface OnItemClickListener {
        void onItemClick(layoutTableDB layout);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}