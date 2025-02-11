package com.eagle.ahpassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.eagle.ahpassignment.fruitList.Fruits;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "My_Db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "Create table my_tab (name text,quantity integer,image text) ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addFruit(Item item){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",item.getFruitName());
        cv.put("quantity",item.getQuantity());
        cv.put("image",item.getImageUrl());
        db.insert("my_tab",null,cv);
    }
    public void updateFruit(Item item){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",item.getFruitName());
        cv.put("quantity",item.getQuantity());
        cv.put("image",item.getImageUrl());
        db.update("my_tab",cv,"name =? ",new String[]{item.getFruitName()});

    }
    public List<Item> getItems(){
        List<Item> itemList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String select= "SELECT * FROM my_tab";

        Cursor cursor = db.rawQuery(select,null);
        if(cursor.moveToFirst()){
            do{
                Item item=new Item();
                item.setFruitName(cursor.getString(0));
                item.setQuantity(Integer.parseInt(cursor.getString(1)));
                item.setImageUrl(cursor.getString(2));
                itemList.add(item);



            }while(cursor.moveToNext());
        }
        return itemList;
    }
    public Item findFruit(String fruitName){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query("my_tab",null,"name =?",new String[]{fruitName},null,null,null);
        Item item=new Item();
        if(cursor.moveToFirst()){
            do{
                item.setImageUrl(cursor.getString(2));
                item.setFruitName(cursor.getString(0));
                item.setQuantity(Integer.parseInt(cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return item;



    }
//    public User findUserById(int id){
//        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
//        Cursor cursor=sqLiteDatabase.query(Constant.TBL_NAME,null,Constant.USER_ID+" +?",new String[]{String.valueOf(id)},null,null,null);
//        User user=new User();
//        if(cursor.moveToFirst()) {
//            do {
//                user.setUserId(id);
//                user.setUserName(cursor.getString(cursor.getColumnIndex(Constant.USER_NAME)));
//                user.setUserPhone(cursor.getString(cursor.getColumnIndex(Constant.USER_PHONE)));
//                user.setUserEmail(cursor.getString(cursor.getColumnIndex(Constant.USER_EMAIL)));
//                user.setUserPassword(cursor.getString(cursor.getColumnIndex(Constant.USER_PASSWORD)));
//            }while(cursor.moveToNext());
//        }
//        cursor.close();
//        return user;
//    }
}
