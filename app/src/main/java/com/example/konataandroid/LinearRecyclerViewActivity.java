package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mLinearRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        mLinearRv = findViewById(R.id.rv_LinearRv);
        mLinearRv.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mLinearRv.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this));
    }
}
