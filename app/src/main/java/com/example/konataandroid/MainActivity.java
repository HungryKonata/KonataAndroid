package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnRv;
    private Button mBtnWv;
    private Button mBtnTv;
    private Button mBtnDialogv;
    private Button mBtnProgv;
    private Button mBtnCostomDv;
    private Button mBtnPop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnRv = findViewById(R.id.rv);
        mBtnWv = findViewById(R.id.wv);
        mBtnTv = findViewById(R.id.toast_view_button);
        mBtnDialogv = findViewById(R.id.dialog_view_button);
        mBtnProgv = findViewById(R.id.btn_progress);
        mBtnCostomDv = findViewById(R.id.btn_custom_dialog);
        mBtnPop = findViewById(R.id.btn_pop_wd);


        setListeners();
    }

    //本来的设计是，给Button来setOnClickListener,要用OnClickListener对象作为传入参数，并且重写它的onClick方法
    //而这里设计了一个继承自OnClickListener的类OnClick,并且在OnClick中重写了继承来的onClick方法，所以只需要传入OnClick类就可以了
    public void setListeners(){   //设计上不用传参onClick，所有的onClick都是一样的
        OnClick onClick = new OnClick();
        mBtnRv.setOnClickListener(onClick);
        mBtnWv.setOnClickListener(onClick);
        mBtnTv.setOnClickListener(onClick);
        mBtnDialogv.setOnClickListener(onClick);
        mBtnProgv.setOnClickListener(onClick);
        mBtnCostomDv.setOnClickListener(onClick);
        mBtnPop.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.rv:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.wv:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.toast_view_button:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.dialog_view_button:
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_custom_dialog:
                    intent = new Intent(MainActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_pop_wd:
                    intent = new Intent(MainActivity.this, PopupActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}
