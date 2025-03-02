package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<CartItem> cartItems;

    public CartAdapter(Context context, List<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.itemImage.setImageResource(cartItem.getImageResourceId());
        holder.itemName.setText(cartItem.getName());
        holder.itemPrice.setText(cartItem.getPrice());
        holder.itemQuantity.setText(String.valueOf(cartItem.getQuantity()));

        holder.decreaseQuantityButton.setOnClickListener(v -> {
            int quantity = cartItem.getQuantity();
            if (quantity > 1) {
                cartItem.setQuantity(quantity - 1);
                holder.itemQuantity.setText(String.valueOf(cartItem.getQuantity()));
                // Update total price (you'll need a method in your activity)
                ((CartActivity) context).updateTotalPrice();
            }
        });

        holder.increaseQuantityButton.setOnClickListener(v -> {
            int quantity = cartItem.getQuantity();
            cartItem.setQuantity(quantity + 1);
            holder.itemQuantity.setText(String.valueOf(cartItem.getQuantity()));
            // Update total price
            ((CartActivity) context).updateTotalPrice();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;
        TextView itemQuantity;
        Button decreaseQuantityButton;
        Button increaseQuantityButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
            decreaseQuantityButton = itemView.findViewById(R.id.decrease_quantity);
            increaseQuantityButton = itemView.findViewById(R.id.increase_quantity);
        }
    }
}
