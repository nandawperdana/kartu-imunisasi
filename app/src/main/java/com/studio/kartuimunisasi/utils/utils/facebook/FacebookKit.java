package com.studio.kartuimunisasi.utils.utils.facebook;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NwP.
 */
public class FacebookKit {
    //         Facebook permission list
    List<String> permission = new ArrayList<String>();
    LoginButton loginButton;
    CallbackManager callbackManager;
    FacebookLoginListener listener;

    public FacebookKit(CallbackManager callbackManager, LoginButton loginButton,
                       FacebookLoginListener listener) {
        this.callbackManager = callbackManager;
        this.listener = listener;

        permission.add("email");
        permission.add("public_profile");
        permission.add("user_friends");

        this.loginButton = loginButton;
//        loginButton.setFragment(fragment);
        loginButton.clearPermissions();
        loginButton.setReadPermissions(permission);
    }

    public void doFacebookLogin() {
        LoginManager.getInstance().logOut();
        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        listener.onSuccessLogin(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        listener.onCancelLogin();
                    }

                    @Override
                    public void onError(FacebookException e) {
                        listener.onErrorLogin(e);
                    }
                });
    }
}