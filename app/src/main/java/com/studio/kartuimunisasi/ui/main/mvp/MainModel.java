package com.studio.kartuimunisasi.ui.main.mvp;

import com.studio.kartuimunisasi.domains.models.UserDomain;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class MainModel {
    public UserDomain userDomain;

    public MainModel() {
        this.userDomain = new UserDomain();
    }
}
