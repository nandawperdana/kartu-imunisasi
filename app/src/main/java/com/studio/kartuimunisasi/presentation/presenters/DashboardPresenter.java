package com.studio.kartuimunisasi.presentation.presenters;

import com.studio.kartuimunisasi.presentation.base.BasePresenter;
import com.studio.kartuimunisasi.presentation.base.BaseView;
import com.studio.kartuimunisasi.ui.dashboard.mvp.DashboardModel;

/**
 * Created by NwP.
 */
public interface DashboardPresenter extends BasePresenter {
    interface DashboardView extends BaseView {
        enum ViewState {
            IDLE, LOADING, ERROR,
            LOAD_MENU, SHOW_MENU
        }

        DashboardModel doRetrieveModel();

        void showProgress(boolean flag);

        void showState(ViewState state);
    }

    void presentState(DashboardView.ViewState state);
}
