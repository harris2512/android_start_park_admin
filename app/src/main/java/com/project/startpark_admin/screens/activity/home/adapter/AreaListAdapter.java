package com.project.startpark_admin.screens.activity.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.startpark_admin.R;

public class AreaListAdapter extends RecyclerView.Adapter<AreaListAdapter.myViewHolder> {

    protected Context context;

    private int thisPosition;
    protected RecyclerView.ViewHolder mViewHolder;
    protected AreaListAdapter.myViewHolder mHolder;
    protected int mPosition;

    private AreaListAdapter.OnItemClickListener onRecyclerViewItemClickListener;

    public AreaListAdapter(Context context) {
        this.context = context;
    }

    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    //Then define a return value method of type int
    public int getThisPosition() {
        return thisPosition - 1;
    }

    //This method is called at the place where this adapter is called, it will not be called in this adapter
    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }

    public void setOnRecyclerViewItemClickListener(AreaListAdapter.OnItemClickListener onItemClickListener) {
        this.onRecyclerViewItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_area_list_item,
                parent, false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        mViewHolder = holder;
        mHolder = holder;
        mPosition = holder.getAdapterPosition();

        if (getThisPosition() != -1 && position == getThisPosition()) {

        } else {

        }

        holder.tv_area_list_item_name.setText("P".concat(String.valueOf(position + 1)).concat(" area"));

        if (onRecyclerViewItemClickListener != null) {
            //Click event
            mViewHolder.itemView.setOnClickListener(v -> onRecyclerViewItemClickListener.onClick(position));

            //Long press event
            mViewHolder.itemView.setOnLongClickListener(v -> {
                onRecyclerViewItemClickListener.onLongClick(position);
                return false;
            });
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_area_list_item_name;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_area_list_item_name = itemView.findViewById(R.id.tv_area_list_item_name);
        }
    }
}
