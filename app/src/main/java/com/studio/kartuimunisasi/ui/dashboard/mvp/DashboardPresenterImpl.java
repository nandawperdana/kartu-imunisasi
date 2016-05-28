package com.studio.kartuimunisasi.ui.dashboard.mvp;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.RootResponseModel;
import com.studio.kartuimunisasi.presentation.presenters.DashboardPresenter;
import com.studio.kartuimunisasi.utils.commons.Enums;

import java.util.List;

/**
 * Created by NwP.
 */
public class DashboardPresenterImpl implements DashboardPresenter, APICallListener {
    DashboardView mView;

    public DashboardPresenterImpl(DashboardView mView) {
        this.mView = mView;
    }

    @Override
    public void presentState(DashboardView.ViewState state) {
        switch (state) {
            case IDLE:
                mView.showState(DashboardView.ViewState.IDLE);
                break;
            case LOADING:
                mView.showState(DashboardView.ViewState.LOADING);
                break;
            case ERROR:
                mView.showState(DashboardView.ViewState.ERROR);
                break;
            case LOAD_MENU:
                presentState(DashboardView.ViewState.LOADING);
                mView.showState(DashboardView.ViewState.LOAD_MENU);
                break;
            case SHOW_MENU:
                mView.showState(DashboardView.ViewState.SHOW_MENU);
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

        }
    }

    @Override
    public void onAPICallSucceed(Enums.APIRoute route, List<RootResponseModel> responseModels) {

    }

    @Override
    public void onAPICallFailed(Enums.APIRoute route, Throwable throwable) {

    }
}
