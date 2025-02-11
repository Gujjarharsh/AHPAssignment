package com.eagle.ahpassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eagle.ahpassignment.fruitList.FruitListAdapter;
import com.eagle.ahpassignment.fruitList.FruitMainResponseModel;
import com.eagle.ahpassignment.fruitList.Fruits;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       recyclerView = findViewById(R.id.myRv);
       Button viewCartButton=findViewById(R.id.viewCartButton);
        ProgressBar progressBar=findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

       viewCartButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,CartShowActivity.class);
               startActivity(intent);
           }
       });


       CommonRetrofit.getInstance().getApiInterface().getAllFruits().enqueue(new Callback<FruitMainResponseModel>() {
           @Override
           public void onResponse(Call<FruitMainResponseModel> call, Response<FruitMainResponseModel> response) {
               if(response.isSuccessful()){
                   progressBar.setVisibility(View.GONE);
                   FruitListAdapter adapter = new FruitListAdapter(MainActivity.this,response.body().getFruits());
                   recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                   recyclerView.setAdapter(adapter);
               }
           }

           @Override
           public void onFailure(Call<FruitMainResponseModel> call, Throwable t) {

           }
       });







    }
}