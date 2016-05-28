package com.studio.kartuimunisasi.ui.dashboard;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.studio.kartuimunisasi.R;
import com.studio.kartuimunisasi.presentation.presenters.DashboardPresenter;
import com.studio.kartuimunisasi.ui.dashboard.adapter.DashboardAdapter;
import com.studio.kartuimunisasi.ui.dashboard.adapter.GridSpacingItemDecoration;
import com.studio.kartuimunisasi.ui.dashboard.mvp.DashboardModel;
import com.studio.kartuimunisasi.ui.dashboard.mvp.DashboardPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardPresenter.DashboardView {
    @Bind(R.id.recyclerview_dashboard)
    RecyclerView recyclerViewCard;
    @Bind(R.id.imageview_dashboard_backdrop)
    ImageView imageViewBackdrop;
    @Bind(R.id.textview_dashboard_title)
    TextView textViewTitle;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.toolbar_dashboard)
    Toolbar toolbar;
    ProgressDialog mProgressDialog;
    DashboardAdapter mAdapter;

    // var
    DashboardModel mModel;
    DashboardPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        init();
    }

    private void init() {
        ButterKnife.bind(this);
        initCollapsingToolbar();

        this.mModel = new DashboardModel();
        this.mPresenter = new DashboardPresenterImpl(this);

        List<DashboardModel.DashboardMenu> menuList = new ArrayList<>();
        menuList.add(new DashboardModel.DashboardMenu("Vaksin", "image", R.id.box_count));
        mAdapter = new DashboardAdapter(menuList, DashboardActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewCard.setLayoutManager(mLayoutManager);
        recyclerViewCard.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerViewCard.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCard.setAdapter(mAdapter);

        this.mProgressDialog = new ProgressDialog(DashboardActivity.this);
        mProgressDialog.setMessage(getResources().getString(R.string.message_loading));
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public DashboardModel doRetrieveModel() {
        return this.mModel;
    }

    @Override
    public void showProgress(boolean flag) {
        if (flag)
            mProgressDialog.show();
        else
            mProgressDialog.dismiss();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(DashboardActivity.this, "" + message, Toast.LENGTH_LONG);
    }

    @Override
    public void showState(ViewState state) {
        switch (state) {
            case IDLE:
                showProgress(false);
                break;
            case LOADING:
                showProgress(true);
                break;
            case ERROR:
                showError();
                break;
            case SHOW_MENU:
                showMenu();
                break;
        }
    }

    // #showstate region
    private void showMenu() {
        mAdapter.notifyDataSetChanged();
    }

    private void showError() {

    }
    // end region
}
