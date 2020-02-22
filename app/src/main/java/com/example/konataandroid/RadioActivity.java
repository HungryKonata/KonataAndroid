package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioActivity extends AppCompatActivity {
    RadioGroup mBtnRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        mBtnRadioButton = findViewById(R.id.group);
        mBtnRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {    //区别于button的Clicked,它是Checked
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);  //Group是一个整体，要根据传入的checkedID找出到底是哪个RadioButton选中了
                Toast.makeText(RadioActivity.this, radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
