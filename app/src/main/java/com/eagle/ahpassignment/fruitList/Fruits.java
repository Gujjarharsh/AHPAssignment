package com.eagle.ahpassignment.fruitList;

import com.google.gson.annotations.SerializedName;

   
public class Fruits {

  // @SerializedName("name")
   String name;

   @SerializedName("source_country")
   String sourceCountry;

   //@SerializedName("color")
   String color;

  @SerializedName("image_url")
   String imageUrl;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }
    public String getSourceCountry() {
        return sourceCountry;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    
}