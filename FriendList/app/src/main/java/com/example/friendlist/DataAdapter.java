package com.example.friendlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    //vars for adapter
    private String names[];
    private Context context;
    private int rowID;

    public DataAdapter(String[] names, Context context, int rowID) {
        this.names = names;
        this.context = context;
        this.rowID = rowID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate row_layout and create a viewholder

        View view = LayoutInflater.from(context).inflate(rowID, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // place data on holder
        holder.text.setText(names[position]);
        holder.icon.setImageResource(R.drawable.dog);

        //make something clickable
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, names[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    //make inner class ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //describe row_layout obj
        public TextView text;
        public ImageView icon;

        public ViewHolder( View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.textView);
            this.icon = itemView.findViewById(R.id.imageView);
        }
    }
}
