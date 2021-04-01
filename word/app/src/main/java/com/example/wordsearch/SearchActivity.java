package com.example.wordsearch;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.R;
import com.example.wordsearch.ui.main.MainFragment;

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
