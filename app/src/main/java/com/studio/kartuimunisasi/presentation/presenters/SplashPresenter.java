package com.studio.kartuimunisasi.presentation.presenters;

import com.studio.kartuimunisasi.presentation.base.BaseView;
import com.studio.kartuimunisasi.ui.splash.mvp.SplashModel;

/**
 * Created by NwP.
 */
public interface SplashPresenter {
    interface SplashView extends BaseView {
        enum ViewState {
            IDLE, LOADING,
            SHOW_SPLASH,
            OPEN_LOGIN, ERROR
        }

        void showState(ViewState state);

        SplashModel doRetrieveModel();

        void showToast(String message);

        void showError();
    }

    void presentState(SplashView.ViewState state);

}
