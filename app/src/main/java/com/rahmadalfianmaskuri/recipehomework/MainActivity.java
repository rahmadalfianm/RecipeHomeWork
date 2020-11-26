package com.rahmadalfianmaskuri.recipehomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RecipeData> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        prepareRecipeList();
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(MainActivity.this, recipeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(recipeListAdapter);
        recipeListAdapter.setOnItemClickListener(onItemClickListener);
    }

    private void prepareRecipeList() {
        recipeList = new ArrayList<>();
        RecipeData data;
        data = new RecipeData(getString(R.string.moo_shu_name), getString(R.string.moo_shu_description), R.drawable.moo_shu_img, getString(R.string.moo_shu_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.grilled_shrimp_name), getString(R.string.grilled_shrimp_description), R.drawable.grilled_shrimp_img, getString(R.string.grilled_shrimp_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.sirloin_tips_name), getString(R.string.sirloin_tips_description), R.drawable.sirloin_tips_img, getString(R.string.sirloin_tips_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.squash_casserole_name), getString(R.string.squash_casserole_description), R.drawable.squash_casserole_img, getString(R.string.squash_casserole_details));
        recipeList.add(data);
        data = new RecipeData(getString(R.string.slow_casserole_name), getString(R.string.slow_casserole_description), R.drawable.slow_casserole_img, getString(R.string.slow_casserole_details));
        recipeList.add(data);
    }

    //Opens the Detail Activity and crates the Bundle data to be displayed
    public void openDetailActivity(int imageId, String details){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("image", imageId);
        intent.putExtra("details", details);
        startActivity(intent);
    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            RecipeData thisRecipe = recipeList.get(position);
            openDetailActivity(thisRecipe.getImage(), thisRecipe.getDetails());
        }
    };
}