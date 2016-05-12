package com.studio.kartuimunisasi.ui.login.mvp;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.RootResponseModel;
import com.studio.kartuimunisasi.presentation.presenters.LoginPresenter;
import com.studio.kartuimunisasi.utils.commons.Enums;

import java.util.List;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class LoginPresenterImpl implements LoginPresenter, APICallListener {
    LoginView mView;

    public LoginPresenterImpl(LoginView mView) {
        this.mView = mView;
    }

    @Override
    public void presentState(LoginView.ViewState state) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, RootResponseModel responseModel) {

    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, List<RootResponseModel> responseModels) {

    }

    @Override
    public void onAPICallFailed(Enums.APIRoute route, Throwable throwable) {

    }

}
