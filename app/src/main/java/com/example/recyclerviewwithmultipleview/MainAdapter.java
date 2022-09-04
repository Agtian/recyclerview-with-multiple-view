package com.example.recyclerviewwithmultipleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    // Initialize variable
    ArrayList<String> arrayList;

    public MainAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initialize view
        View view;
        // Check condition
        if (viewType == 2) {
            // When view type is equal to 2
            // Inflate main2 layout
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main2, parent, false);
        } else {
            // When view type is equal to 1
            // Inflate main1 layout
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main1, parent, false);
        }
        // Return holder view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set text on text view
        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        // Return array list size
        return arrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        // Check condition
        if ((position+1) % 5 * 2 == 0) {
            // When position in table of 5
            // Return main2
            return 2;
        } else {
            // When position in table of 5
            // Return main
            return 1;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Initialize variable
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Assign variable
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
