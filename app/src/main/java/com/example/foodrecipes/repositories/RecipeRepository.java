package com.example.foodrecipes.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.requests.RecipeApiClient;

import java.util.List;

public class RecipeRepository {
    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

    public static RecipeRepository getInstance() {
            if(instance == null){
                instance = new RecipeRepository();
            }
           return instance;
    }

    public RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public void searchRecipeApi(String query, int pageNumber)
    {
        if(pageNumber == 0){
            pageNumber = 1;
        }
        mRecipeApiClient.searchRecipeApi(query, pageNumber);
    }

    public LiveData<List<Recipe>> getRecipe(){
        return mRecipeApiClient.getRecipe();
    }
}
