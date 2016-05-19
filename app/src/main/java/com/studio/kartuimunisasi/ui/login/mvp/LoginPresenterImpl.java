package com.studio.kartuimunisasi.ui.login.mvp;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.RootResponseModel;
import com.studio.kartuimunisasi.api.v1.user.UsersModel;
import com.studio.kartuimunisasi.domains.interactors.UserInteractor;
import com.studio.kartuimunisasi.presentation.presenters.LoginPresenter;
import com.studio.kartuimunisasi.utils.commons.Enums;

import java.util.List;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class LoginPresenterImpl implements LoginPresenter, APICallListener {
    LoginView mView;
    UserInteractor mUserInteractor;

    public LoginPresenterImpl(LoginView mView) {
        this.mView = mView;
        this.mUserInteractor = new UserInteractor(this);
    }

    @Override
    public void presentState(LoginView.ViewState state) {
        switch (state) {
            case IDLE:
                mView.showState(LoginView.ViewState.IDLE);
                break;
            case LOADING:
                mView.showState(LoginView.ViewState.LOADING);
                break;
            case LOAD_LOGIN_FACEBOOK:
                mView.showState(LoginView.ViewState.LOAD_LOGIN_FACEBOOK);
                break;
            case LOAD_LOGIN:
                presentState(LoginView.ViewState.LOADING);
                mUserInteractor.callAPILoginFacebook(mView.doRetrieveModel().getToken());
                break;
            case SHOW_LOGIN:
                mView.showState(LoginView.ViewState.SHOW_LOGIN);
                break;
            case ERROR:
                mView.showState(LoginView.ViewState.ERROR);
                break;
        }
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
        switch (route) {
            case LOGIN:
                mView.doRetrieveModel().userDomain.setUsersModel((UsersModel) responseModel);
                presentState(LoginView.ViewState.SHOW_LOGIN);
                break;
        }
    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, List<RootResponseModel> responseModels) {

    }

    @Override
    public void onAPICallFailed(Enums.APIRoute route, Throwable throwable) {
        switch (route) {
            case LOGIN:
                presentState(LoginView.ViewState.ERROR);
                break;
        }
    }

}
