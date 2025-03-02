package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FurnitureItemActivity extends AppCompatActivity {

    private RecyclerView productsRecyclerView;
    private FurnitureAdapter furnitureAdapter;
    private List<Furniture> furnitureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.furniture_item); // Your main layout XML file

        productsRecyclerView = findViewById(R.id.products_recycler_view);
        productsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        // Initialize data (replace with your actual data)
        furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture("Arm Chair", "Rs: 10,000", "5.0", R.drawable.item1)); // Replace with your image resources
        furnitureList.add(new Furniture("Club Chair", "Rs: 12,000", "4.0", R.drawable.item2));
        furnitureList.add(new Furniture("Tulip Chair", "Rs: 15,000", "4.5", R.drawable.item3));
        furnitureList.add(new Furniture("Modern Chair", "Rs: 20,000", "5.0", R.drawable.item4_1));


        furnitureAdapter = new FurnitureAdapter(this, furnitureList);
        productsRecyclerView.setAdapter(furnitureAdapter);
    }
}