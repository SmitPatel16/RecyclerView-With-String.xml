package com.example.recyclerviewp20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<FoodModel> arrayFoodList = new ArrayList<>();
    String[] foodItemNameArray, foodItemOriginArray;
    TypedArray foodItemImageArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        foodItemNameArray = getResources().getStringArray(R.array.foodItemNameArray);
        foodItemOriginArray = getResources().getStringArray(R.array.foodItemOriginArray);
        foodItemImageArray = getResources().obtainTypedArray(R.array.foodItemImageArray);


        RecyclerView recyclerView = findViewById(R.id.recyclerFoodItem);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        RecyclerFoodItemAdapter recyclerFoodItemAdapter = new RecyclerFoodItemAdapter(this, foodItemImageArray, foodItemNameArray, foodItemOriginArray);
        recyclerView.setAdapter(recyclerFoodItemAdapter);

        /*

             ******************  Perfectly working  *************************

        FoodModel foodModel = new FoodModel(R.drawable.birthdaycake,"Cake","Western");
        arrayFoodList.add(foodModel);
        arrayFoodList.add(new FoodModel(R.drawable.chocolate,"Chacolate","USA"));
        arrayFoodList.add(new FoodModel(R.drawable.chocolate,"Chacolate","USA"));
        arrayFoodList.add(new FoodModel(R.drawable.chocolate,"Chacolate","USA"));
        arrayFoodList.add(new FoodModel(R.drawable.chocolate,"Chacolate","USA"));
        arrayFoodList.add(new FoodModel(R.drawable.chocolate,"Chacolate","USA"));
        arrayFoodList.add(new FoodModel(R.drawable.chocolate,"Chacolate","USA"));

        RecyclerFoodItemAdapter recyclerFoodItemAdapter = new RecyclerFoodItemAdapter(this, arrayFoodList);
        recyclerView.setAdapter(recyclerFoodItemAdapter);
*/


    }
}