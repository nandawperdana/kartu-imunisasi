package com.studio.kartuimunisasi.utils.utils.facebook;

import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

/**
 * Created by NwP.
 */
public interface FacebookLoginListener {
    void onSuccessLogin(LoginResult loginResult);

    void onErrorLogin(FacebookException exception);

    void onCancelLogin();
}
