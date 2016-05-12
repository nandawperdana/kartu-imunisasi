package com.studio.kartuimunisasi.ui.main.mvp;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.RootResponseModel;
import com.studio.kartuimunisasi.presentation.presenters.MainPresenter;
import com.studio.kartuimunisasi.utils.commons.Enums;

import java.util.List;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class MainPresenterImpl implements MainPresenter, APICallListener {
    MainView mView;

    public MainPresenterImpl(MainView mView) {
        this.mView = mView;
    }

    @Override
    public void presentState(MainView.ViewState state) {
        switch (state) {
            case IDLE:
                mView.showState(MainView.ViewState.IDLE);
                break;
            case LOADING:
                mView.showState(MainView.ViewState.LOADING);
                break;
            case ERROR:
                mView.showState(MainView.ViewState.ERROR);
                break;
            case LOAD_USER:
                mView.showState(MainView.ViewState.LOAD_USER);
                break;
            case SHOW_USER:
                mView.showState(MainView.ViewState.SHOW_USER);
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

    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, List<RootResponseModel> responseModels) {

    }

    @Override
    public void onAPICallFailed(Enums.APIRoute route, Throwable throwable) {

    }
}
