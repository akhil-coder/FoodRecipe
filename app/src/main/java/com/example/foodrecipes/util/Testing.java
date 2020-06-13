package com.example.foodrecipes.util;

import android.util.Log;

import com.example.foodrecipes.models.Recipe;

import java.util.List;

public class Testing {
    private static final String TAG = "Testing";
    public static void printRecipes(List<Recipe> list) {
        for(Recipe recipe:list) {
            Log.d(TAG, "onChanged: " + recipe.getTitle());
        }
    }
}
