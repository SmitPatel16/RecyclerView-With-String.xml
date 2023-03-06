package com.example.recyclerviewp20;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerFoodItemAdapter extends RecyclerView.Adapter<RecyclerFoodItemAdapter.ViewHolder> {

//    Context context;
//    ArrayList<FoodModel> arrayFoodList;
//    RecyclerFoodItemAdapter(Context context, ArrayList<FoodModel> arrayFoodList){
//        this.context = context;
//        this.arrayFoodList = arrayFoodList;
//    }
    private int lastPosition=-1;
    Context context;
    String[] foodItemNameArray, foodItemOriginArray;
    TypedArray foodItemImageArray;

    RecyclerFoodItemAdapter(Context context, TypedArray foodItemImageArray, String[] foodItemNameArray, String[] foodItemOriginArray){
        this.context = context;
        this.foodItemImageArray = foodItemImageArray;
        this.foodItemNameArray = foodItemNameArray;
        this.foodItemOriginArray = foodItemOriginArray;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodItemImage;
        TextView foodItemName,foodItemOrigin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodItemImage = itemView.findViewById(R.id.foodItemImage);
            foodItemName = itemView.findViewById(R.id.foodItemName);
            foodItemOrigin = itemView.findViewById(R.id.foodItemOrigin);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.foodItemImage.setImageResource(foodItemImageArray.getResourceId(position,0));
        holder.foodItemName.setText(foodItemNameArray[position]);
        holder.foodItemOrigin.setText(foodItemOriginArray[position]);

        setAnimation(holder.itemView, position);

        //
//        holder.foodItemImage.setImageResource(arrayFoodList.get(position).foodItemImage);
//        holder.foodItemName.setText(arrayFoodList.get(position).foodItemName);
//        holder.foodItemOrigin.setText(arrayFoodList.get(position).foodItemOrigin);
    }

    @Override
    public int getItemCount() {
        return foodItemNameArray.length;
    }

    private void setAnimation(View viewToAnimate, int position){
        if(position>lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition=position;
        }
    }
}
