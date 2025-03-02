package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.FurnitureViewHolder> {

    private Context context;
    private List<Furniture> furnitureList;

    public FurnitureAdapter(Context context, List<Furniture> furnitureList) {
        this.context = context;
        this.furnitureList = furnitureList;
    }

    @NonNull
    @Override
    public FurnitureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.furniture_item, parent, false);
        return new FurnitureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureViewHolder holder, int position) {
        Furniture furniture = furnitureList.get(position);
        holder.furnitureName.setText(furniture.getName());
        holder.furniturePrice.setText(furniture.getPrice());
        holder.furnitureRating.setText(furniture.getRating());
        holder.furnitureImage.setImageResource(furniture.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return furnitureList.size();
    }

    public static class FurnitureViewHolder extends RecyclerView.ViewHolder {
        ImageView furnitureImage;
        TextView furnitureName;
        TextView furniturePrice;
        TextView furnitureRating;

        public FurnitureViewHolder(@NonNull View itemView) {
            super(itemView);
            furnitureImage = itemView.findViewById(R.id.furniture_image);
            furnitureName = itemView.findViewById(R.id.furniture_name);
            furniturePrice = itemView.findViewById(R.id.furniture_price);
            furnitureRating = itemView.findViewById(R.id.furniture_rating);
        }
    }
}