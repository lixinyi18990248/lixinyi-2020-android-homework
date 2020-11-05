package com.example.homework004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;

import com.example.homework004.bean.UserInfo;
import com.example.homework004.database.UserDBHelper;
import com.example.homework004.util.DateUtil;

public class SQLiteWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="SQLiteWriteActivity";//Log提示信息
    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private EditText et_pwd;
    private EditText et_repwd;
    private EditText et_phone;
    private boolean BMsex = false;

    private int mRequestCode = 0;//跳转页面时的请求代码
    private int mType =0;//用户类型
    private boolean bRemember =false;//是否记住密码
    private String mVerifyCode;//验证码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_write);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        et_pwd=findViewById(R.id.et_pwd);
        et_repwd=findViewById(R.id.et_repwd);
        et_phone=findViewById(R.id.et_phone);
        findViewById(R.id.btn_save).setOnClickListener(this);

        Spinner sp_sex = findViewById(R.id.sp_Sex);
        sp_sex.setOnItemSelectedListener(new TypeSelectedListener());

    }

    class TypeSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            BMsex = (arg2 == 0) ? false : true;
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart:openLink");
        super.onStart();
        // 获得数据库帮助器的实例
        mHelper = UserDBHelper.getInstance(this, 2);
        // 打开数据库帮助器的写连接
        mHelper.openWriteLink();
        //打开数据库帮助的读连接
        mHelper.openReadLink();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStart:closeLink");
        super.onStop();
        // 关闭数据库连接
        mHelper.closeLink();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_save) {
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            String pwd=et_pwd.getText().toString();
            String repwd=et_repwd.getText().toString();
            String phone=et_phone.getText().toString();
            if (TextUtils.isEmpty(name)) {
                showToast("请先填写姓名");
                return;
            } else if (TextUtils.isEmpty(age)) {
                showToast("请先填写年龄");
                return;
            } else if (TextUtils.isEmpty(height)) {
                showToast("请先填写身高");
                return;
            } else if (TextUtils.isEmpty(weight)) {
                showToast("请先填写体重");
                return;
            } else if(!pwd.equals(repwd)){
                showToast("两次输入的密码不一致");
                return;
            } else if (TextUtils.isEmpty(phone)) {
                showToast("请先填写手机号");
                return;
            }

            // 以下声明一个用户信息对象，并填写它的各字段值
            UserInfo info = new UserInfo();
            info.name = name;
            info.age = Integer.parseInt(age);
            info.height = Long.parseLong(height);
            info.weight = Float.parseFloat(weight);
            info.Sex = BMsex;
            info.update_time = DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss");
            info.pwd=pwd;
            info.phone=phone;

            // 执行数据库帮助器的插入操作
            mHelper.insert(info);
            showToast("数据已写入SQLite数据库");


            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void showToast(String desc) {
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }
}