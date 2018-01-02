package com.example.playgirl.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import login.PresenterLogicLogin;
import login.ViewLogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewLogin {

    private EditText edtUserName, edtPassWord;
    private Button btnLogin;

    private PresenterLogicLogin presenterLogicLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnLogin.setOnClickListener(this);
        presenterLogicLogin = new PresenterLogicLogin( this);
    }

    private void init(){
        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPassWord = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View view) {
        String userName, passWord;
        userName = edtUserName.getText().toString();
        passWord = edtPassWord.getText().toString();
        presenterLogicLogin.checkLogin(userName,passWord);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"loginSuccess",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this,"loginFail",Toast.LENGTH_SHORT).show();
    }
}
