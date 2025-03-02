package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;
    private TextView totalPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartRecyclerView = findViewById(R.id.cart_recycler_view);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        totalPriceTextView = findViewById(R.id.total_price);

        // Initialize Cart Items (Replace with your actual data)
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Sofa", "10000", 1, R.drawable.sofa1));
        cartItems.add(new CartItem("Sofa", "15000", 1, R.drawable.sofa2));

        cartAdapter = new CartAdapter(this, cartItems);
        cartRecyclerView.setAdapter(cartAdapter);

        updateTotalPrice();

        Button buyNowButton = findViewById(R.id.buy_now_button);
        buyNowButton.setOnClickListener(v -> {
            // Handle buy now logic here
            //Example:
            //Toast.makeText(this, "Buy Now clicked!", Toast.LENGTH_SHORT).show();
        });
    }

    // Call this method from the adapter when quantity changes
    public void updateTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
            totalPrice += Integer.parseInt(item.getPrice()) * item.getQuantity();
        }
        totalPriceTextView.setText("Rs: " + totalPrice);
    }
}