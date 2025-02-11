package com.eagle.ahpassignment.fruitList;
import java.util.List;


public class FruitMainResponseModel {

   //@SerializedName("status")
  boolean status;

  // @SerializedName("message")
   String message;

  // @SerializedName("fruits")
   List<Fruits> fruits;


    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus() {
        return status;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    
    public void setFruits(List<Fruits> fruits) {
        this.fruits = fruits;
    }
    public List<Fruits> getFruits() {
        return fruits;
    }
    
}