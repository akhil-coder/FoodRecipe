package com.example.foodrecipes.requests;

import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.requests.response.RecipeResponse;
import com.example.foodrecipes.requests.response.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    //Search
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("q") String query,
            @Query("page") String page
    );

    //Get Recipe
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("rId") String recipe_id
    );
}
