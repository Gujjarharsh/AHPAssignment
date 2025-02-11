package com.eagle.ahpassignment.fruitList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.eagle.ahpassignment.R;
import com.eagle.ahpassignment.AddToCartActivity;


import java.util.List;

public class FruitListAdapter extends RecyclerView.Adapter<FruitListAdapter.FruitViewHolder> {
    private Context context;
    private List<Fruits>fruitsList;

    public FruitListAdapter(Context context, List<Fruits>fruitsList) {
        this.context = context;
        this.fruitsList = fruitsList;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.fruits_details, parent, false);
        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruits fruits=fruitsList.get(position);
        holder.fruitNameTv.setText(fruits.getName());
        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, AddToCartActivity.class);
                intent.putExtra("fruitName",fruits.getName());
                intent.putExtra("fruitImage",fruits.getImageUrl());

                context.startActivity(intent);
            }
        });

        Glide.with(context)
                .load(fruits.getImageUrl())
                .into(holder.fruitImageImg);
    }

    @Override
    public int getItemCount() {
        Log.d("SizeOfList","Size is"+fruitsList.size());
        return fruitsList.size();

    }
    public class FruitViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImageImg;
        TextView fruitNameTv;
        Button addToCartBtn;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitImageImg=itemView.findViewById(R.id.fruitImageTmg);
            fruitNameTv=itemView.findViewById(R.id.fruitNameTv);
            addToCartBtn=itemView.findViewById(R.id.addToCartBtn);

        }
    }
}
