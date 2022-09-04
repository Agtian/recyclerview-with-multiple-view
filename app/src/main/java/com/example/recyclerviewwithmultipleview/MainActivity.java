package com.example.recyclerviewwithmultipleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Initialize variable
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variable
        recyclerView = findViewById(R.id.recycle_view);

        // Initialize array list
        ArrayList<String> arrayList = new ArrayList<>();
        // User loop
        for (int i=0; i<40; i++) {
            // Add values in array list
            arrayList.add("Item " + i);
        }

        // Initialize layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(
                this, 2
        );
        // Set span size
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // Check condition
                if ((position+1) % 5 * 2 == 0) {
                    // When position ill be in table of 5
                    // Return span size 2
                    return 2;
                } else {
                    // When position will not be in table of 5
                    // Return span size 1
                    return 1;
                }
            }
        });
        // Set layout manager
        recyclerView.setLayoutManager(layoutManager);
        // Set adapter
        recyclerView.setAdapter(new MainAdapter(arrayList));

    }
}