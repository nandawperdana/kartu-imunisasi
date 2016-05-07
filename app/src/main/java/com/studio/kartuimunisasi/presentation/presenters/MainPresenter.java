package com.studio.kartuimunisasi.presentation.presenters;

import com.studio.kartuimunisasi.presentation.base.BasePresenter;
import com.studio.kartuimunisasi.presentation.base.BaseView;

/**
 * Created by NwP.
 */
public interface MainPresenter extends BasePresenter {
    interface MainView extends BaseView {
        enum ViewState {
            IDLE, LOADING, ERROR,
            LOAD_USER, SHOW_USER
        }

        void showState(ViewState state);
    }

    void presentState(MainView.ViewState state);
}
