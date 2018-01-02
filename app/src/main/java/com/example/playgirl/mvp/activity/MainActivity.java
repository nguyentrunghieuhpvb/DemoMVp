package com.example.playgirl.mvp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.playgirl.mvp.R;
import com.example.playgirl.mvp.login.PresenterLogicLogin;
import com.example.playgirl.mvp.login.ViewLogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewLogin {
    private EditText edtUserName, edtPassWord;
    private Button btnLogin, btnAddCity, btnShowCity;
    private PresenterLogicLogin presenterLogicLogin;
    private LinearLayout llOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(this);
        btnAddCity.setOnClickListener(this);
        presenterLogicLogin = new PresenterLogicLogin(this);
    }

    private void init() {
        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPassWord = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnAddCity = (Button) findViewById(R.id.btn_add_city);
        btnShowCity = (Button) findViewById(R.id.btn_show_city);
        llOption = findViewById(R.id.ll_option);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                String userName, passWord;
                userName = edtUserName.getText().toString();
                passWord = edtPassWord.getText().toString();
                presenterLogicLogin.checkLogin(userName, passWord);
                break;
            case R.id.btn_add_city:
                Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "loginSuccess", Toast.LENGTH_SHORT).show();
        llOption.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "loginFail", Toast.LENGTH_SHORT).show();
    }
}
