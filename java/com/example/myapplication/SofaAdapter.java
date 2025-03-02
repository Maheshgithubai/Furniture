package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SofaAdapter extends RecyclerView.Adapter<SofaAdapter.SofaViewHolder> {

    private List<SofaItem> sofaList;

    public SofaAdapter(List<SofaItem> sofaList) {
        this.sofaList = sofaList;
    }

    public static class SofaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewSofa;
        TextView textViewSofaName;
        TextView textViewSofaPrice;
        TextView textViewSofaRating;

        public SofaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSofa = itemView.findViewById(R.id.imageViewSofa);
            textViewSofaName = itemView.findViewById(R.id.textViewSofaName);
            textViewSofaPrice = itemView.findViewById(R.id.textViewSofaPrice);
            textViewSofaRating = itemView.findViewById(R.id.textViewSofaRating);
        }
    }

    @NonNull
    @Override
    public SofaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sofa, parent, false);
        return new SofaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SofaViewHolder holder, int position) {
        SofaItem sofaItem = sofaList.get(position);
        holder.imageViewSofa.setImageResource(sofaItem.getImageResId());
        holder.textViewSofaName.setText(sofaItem.getName());
        holder.textViewSofaPrice.setText(sofaItem.getPrice());
        holder.textViewSofaRating.setText(String.valueOf(sofaItem.getRating()));
    }

    @Override
    public int getItemCount() {
        return sofaList.size();
    }
}