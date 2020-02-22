package com.example.konataandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PuRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);

        mRvGu = findViewById(R.id.rv_pu);
        mRvGu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvGu.addItemDecoration(new MyDecoration());
        mRvGu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener()
        {
            @Override
            public void onClick(int pos)
            {
                Toast.makeText(PuRecyclerViewActivity.this, "click: " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration
    {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
        {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = 5;
            outRect.set(gap, gap, gap, gap);
        }
    }
}
