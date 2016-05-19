package com.studio.kartuimunisasi.ui.login.mvp;

import com.studio.kartuimunisasi.domains.models.UserDomain;
import com.studio.kartuimunisasi.utils.utils.facebook.FacebookKit;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class LoginModel {
    public UserDomain userDomain;

    private String token;
    private FacebookKit facebookKit;

    public LoginModel() {
        this.userDomain = new UserDomain();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public FacebookKit getFacebookKit() {
        return facebookKit;
    }

    public void setFacebookKit(FacebookKit facebookKit) {
        this.facebookKit = facebookKit;
    }
}
