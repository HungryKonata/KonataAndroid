package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecyclerActivity extends AppCompatActivity {

    private Button mBtnLinearRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mBtnLinearRv = findViewById(R.id.rvBtn1);

        mBtnLinearRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this, LinearRecyclerViewActivity.class);
                //不要忘记！！intent之后要start！！忘记好多次了
                startActivity(intent);
            }
        });
    }
}
