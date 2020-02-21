package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupActivity extends AppCompatActivity {

    //PopupWindow是一个点击产生的下拉窗
    private Button mBtnPop;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mBtnPop = findViewById(R.id.popup);
        //在某个Btn添加new一个popup的点击事件，popup的样式由传入的view给定
        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_popup, null);   //ViewGroup是啥？第二个参数是ViewGroup
                //以下是关键（构造）函数,构造PopupWindow时
                mPop = new PopupWindow(view, mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                //绑定位置
                mPop.setOutsideTouchable(true);  //点击其他地方后会小时
                mPop.setFocusable(true);   //再次点击时会消失
                mPop.showAsDropDown(mBtnPop);
            }
        });
    }
}
