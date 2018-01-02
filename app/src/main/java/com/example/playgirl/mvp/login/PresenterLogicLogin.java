package com.example.playgirl.mvp.login;

/**
 * Created by playgirl on 1/2/18.
 */
//
public class PresenterLogicLogin implements PresenterImpLogin{
    public ViewLogin viewLogin;

    public PresenterLogicLogin(ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
    }

    @Override
    public void checkLogin(String userName, String p) {
        if(userName.equals(ModelLogin.USERNAME) && p.equals(ModelLogin.PASSWORD)){
            viewLogin.loginSuccess();
        }else{
            viewLogin.loginFail();
        }
    }
}
