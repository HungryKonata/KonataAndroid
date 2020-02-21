package com.example.konataandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog = findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomDialog);
                customDialog.setTitle("提示").setMessage("确认删除此项？")
                        .setCancel("取消", new CustomDialog.IonCancelListener()
                        {
                            @Override
                            public void onCancel(CustomDialog dialog)
                            {
                                Toast.makeText(getApplicationContext(), "完成", Toast.LENGTH_SHORT);
                            }
                        }).setConfirm("确认", new CustomDialog.IonConfirmListener()
                {
                    @Override
                    public void onConfirm(CustomDialog dialog)
                    {
                        Toast.makeText(getApplicationContext(), "完成", Toast.LENGTH_SHORT);
                    }
                }).show();
            }
        });
    }
}
