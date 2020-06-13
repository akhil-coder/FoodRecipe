package com.example.foodrecipes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipes.adapters.OnRecipeListener;
import com.example.foodrecipes.adapters.RecipeRecyclerAdapter;
import com.example.foodrecipes.models.Recipe;
import com.example.foodrecipes.util.Testing;
import com.example.foodrecipes.viewmodels.RecipeListViewModel;

import java.util.List;

public class RecipeListActivity extends BaseActivity implements OnRecipeListener {
    private static final String TAG = "RecipeListActivity";
    private RecipeListViewModel mRecipeListViewModel;
    private RecyclerView mRecylerView;
    private RecipeRecyclerAdapter mRecipeRecyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecylerView = findViewById(R.id.recipe_list);
        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);
        initRecyclerView();
        subscribeObservers();
        testRetrofitRequest();
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getmRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if(recipes != null){
                    Testing.printRecipes(recipes);
                    mRecipeRecyclerAdapter.setmRecipes(recipes);
            }
            }
        });
    }
    private void initRecyclerView(){
        mRecipeRecyclerAdapter = new RecipeRecyclerAdapter( this);
        mRecylerView.setAdapter(mRecipeRecyclerAdapter);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void searchRecipeApi(String query, int pageNumber)
    {
        mRecipeListViewModel.searchRecipeApi(query, pageNumber);
    }

    private void testRetrofitRequest(){
       searchRecipeApi("Chicken breast", 1);
    }

    @Override
    public void onRecipeClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }
}
