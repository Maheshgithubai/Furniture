package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SofaSectionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SofaAdapter sofaAdapter;
    private List<SofaItem> sofaList = new ArrayList<>(); // Your data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa_section);

        recyclerView = findViewById(R.id.recyclerViewSofas);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns
        sofaAdapter = new SofaAdapter(sofaList);
        recyclerView.setAdapter(sofaAdapter);

        // Add some sample data
        sofaList.add(new SofaItem("Couch Sofa", "Rs:10,000", 5.0, R.drawable.top));
        sofaList.add(new SofaItem("Settee Sofa", "Rs:12,000", 4.0, R.drawable.sofa11));
        sofaList.add(new SofaItem("Divan Sofa", "Rs:15,000", 4.5, R.drawable.sofa2));
        sofaList.add(new SofaItem("Chesterfield Sofa", "Rs:20,000", 5.0, R.drawable.sofa3));
        sofaList.add(new SofaItem("Loveseat Sofa", "Rs:22,000", 3.5, R.drawable.sofa4));
        sofaList.add(new SofaItem("Sectional Sofa", "Rs:25,000", 4.0, R.drawable.sofa5));

        sofaAdapter.notifyDataSetChanged(); // Refresh the RecyclerView
    }
}