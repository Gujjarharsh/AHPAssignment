package com.eagle.ahpassignment;

import com.eagle.ahpassignment.fruitList.FruitMainResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface   {
    @GET("c/ab64-05c3-4257-882c")
    Call<FruitMainResponseModel> getAllFruits();

}
