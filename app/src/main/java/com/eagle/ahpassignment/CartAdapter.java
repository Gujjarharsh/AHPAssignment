package com.eagle.ahpassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eagle.ahpassignment.fruitList.FruitListAdapter;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    List<Item>itemList;
    CartAdapter(Context context, List<Item>itemList){
        this.context=context;
        this.itemList=itemList;
    }
    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_in_cart_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
           Item item=itemList.get(position);

           holder.fruitName.setText(item.getFruitName());
           holder.noOfQuantity.setText(""+item.getQuantity());
        Glide.with(context)
                .load(item.getImageUrl())
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;
        TextView noOfQuantity;
        ImageView image;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitName=itemView.findViewById(R.id.tvFruitName);
            noOfQuantity=itemView.findViewById(R.id.tvNoOfItem);
            image=itemView.findViewById(R.id.imgFruit);
        }
    }
}
