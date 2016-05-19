package com.studio.kartuimunisasi.presentation.presenters;

import com.studio.kartuimunisasi.presentation.base.BasePresenter;
import com.studio.kartuimunisasi.presentation.base.BaseView;
import com.studio.kartuimunisasi.ui.login.mvp.LoginModel;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public interface LoginPresenter extends BasePresenter {
    interface LoginView extends BaseView {
        enum ViewState {
            IDLE, LOADING,
            LOAD_LOGIN, SHOW_LOGIN,
            LOAD_LOGIN_FACEBOOK, ERROR
        }

        void showState(ViewState state);

        LoginModel doRetrieveModel();
    }

    void presentState(LoginView.ViewState state);
}
