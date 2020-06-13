package com.example.foodrecipes;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class BaseActivity extends AppCompatActivity {
    public ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID) {
        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar);
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(constraintLayout);
    }

    void showProgressBar(Boolean visibility) {
        mProgressBar.setVisibility(visibility? View.VISIBLE: View.INVISIBLE);
    }
}
