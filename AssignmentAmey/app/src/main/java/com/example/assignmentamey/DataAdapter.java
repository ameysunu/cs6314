package com.example.assignmentamey;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private PersonDetails[] personDetails;
    private int[] images;
    private int rowId;
    private Context context;

    public DataAdapter(PersonDetails[] personDetails,int[] images, int rowId, Context context) {
        this.personDetails = personDetails;
        this.images=images;
        this.rowId = rowId;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.myName.setText(personDetails[position].getLocation());
        holder.myPhoto.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(context,DetailView.class);
                intent.putExtra("names",personDetails[position]);
                intent.putExtra("images",images[position]);
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return personDetails.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myName;
        public ImageView myPhoto;
        LinearLayout mainLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            myName = (TextView) itemView.findViewById(R.id.textView);
            myPhoto = (ImageView) itemView.findViewById(R.id.imageView);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
