package com.studio.kartuimunisasi.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.studio.kartuimunisasi.R;
import com.studio.kartuimunisasi.presentation.presenters.MainPresenter;
import com.studio.kartuimunisasi.ui.main.mvp.MainModel;

public class LoginActivity extends AppCompatActivity implements MainPresenter.MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void showState(ViewState state) {

    }

    @Override
    public MainModel doRetrieveModel() {
        return null;
    }

    @Override
    public void showProgress(boolean flag) {

    }

    @Override
    public void showToast(String message) {

    }
}
