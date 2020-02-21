package com.example.konataandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4, mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = findViewById(R.id.btn_diolog1);
        mBtnDialog2 = findViewById(R.id.btn_diolog2);
        mBtnDialog3 = findViewById(R.id.btn_diolog3);
        mBtnDialog4 = findViewById(R.id.btn_diolog4);
        mBtnDialog5 = findViewById(R.id.btn_diolog5);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.btn_diolog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("迷之提问").setMessage("你喜欢哪个人物?").setIcon(R.drawable.bangzhu).setPositiveButton("泉此方", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this, "我也喜欢", Toast.LENGTH_SHORT).show();
                        }
                    }).setNeutralButton("新垣结衣", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "新垣结衣天下第二", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("千反田爱琉", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "我滴头像就是千反田~", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;

                case R.id.btn_diolog2:
                    final String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("请选择性别").setItems(array2, new DialogInterface.OnClickListener()    //所谓的Item与RecyclerView中的Item很相似,setItems方法要求输入数组，数组的每一项是一个Item
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            Toast.makeText(getApplicationContext(), array2[i], Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;

                case R.id.btn_diolog3:
                    final String[] array3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("请选择性别").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener()   //类似于RadioButton
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            Toast.makeText(getApplicationContext(), array3[i], Toast.LENGTH_SHORT).show();
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;

                case R.id.btn_diolog4:
                    final String[] array4 = new String[]{"唱", "跳", "RAP"};
                    final boolean[] isCheckd = new boolean[]{false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isCheckd, new DialogInterface.OnMultiChoiceClickListener()  //类似于CheckedButton
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b)
                        {
                            Toast.makeText(getApplicationContext(), array4[i], Toast.LENGTH_SHORT).show();
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {

                        }
                    }).show();
                    break;

                case R.id.btn_diolog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View loginview = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText username = loginview.findViewById(R.id.et_username);
                    EditText password = loginview.findViewById(R.id.et_password);
                    Button btnLogin = loginview.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {
                            //
                        }
                    });
                    builder5.setTitle("请先登录").setView(loginview).show();
                    break;
            }
        }
    }
}
