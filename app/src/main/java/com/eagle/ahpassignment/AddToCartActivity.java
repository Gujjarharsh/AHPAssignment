package com.eagle.ahpassignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class AddToCartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_add_to_cart);
        Button decreaseQuantity=findViewById(R.id.decreaseQuantity);
        Button increaseQuantity=findViewById(R.id.increaseQuantity);
        ImageView productImage=findViewById(R.id.productImage);
        TextView productTitle=findViewById(R.id.productTitle);
        productTitle.setText(getIntent().getStringExtra("fruitName"));
        Glide.with(this)
                .load(getIntent().getStringExtra("fruitImage"))
                .into(productImage);
        Button viewCartButton=findViewById(R.id.viewCartButton);
        TextView quantity=findViewById(R.id.quantity);
        decreaseQuantity.setText("-");
        increaseQuantity.setText("+");
        decreaseQuantity.setBackgroundColor(Color.TRANSPARENT);
        increaseQuantity.setBackgroundColor(Color.TRANSPARENT);
        decreaseQuantity.setTextColor(Color.RED);
        increaseQuantity.setTextColor(Color.RED);

        decreaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

String quantityText=quantity.getText().toString();
                int quantityNumber = Integer.parseInt(quantityText);
                if (quantityNumber > 1) {
                    quantityNumber--;
                    quantity.setText(String.valueOf(quantityNumber));

//                    quantity.setText(String.valueOf(quantity));
                }
            }
        });

        increaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityText = quantity.getText().toString();
                int quantityNumber = Integer.parseInt(quantityText);
                quantityNumber++;
                quantity.setText(String.valueOf(quantityNumber));
            }
        });

        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddToCartActivity.this, CartShowActivity.class);
                startActivity(intent);
            }
        });
        Button addToCartBtn=findViewById(R.id.addToCartButton);
        addToCartBtn.setOnClickListener(view->{
            DBHelper db=new DBHelper(this);
            Item item=new Item();
            item.setFruitName(productTitle.getText().toString());
            item.setQuantity(Integer.parseInt(quantity.getText().toString()));
            db.addFruit(item);
            Intent intent = new Intent(AddToCartActivity.this, CartShowActivity.class);
            startActivity(intent);
            finish();


        });
    }
}