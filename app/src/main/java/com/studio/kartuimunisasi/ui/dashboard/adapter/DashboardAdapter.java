package com.studio.kartuimunisasi.ui.dashboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.kartuimunisasi.R;
import com.studio.kartuimunisasi.ui.dashboard.mvp.DashboardModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by NwP.
 */
public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    List<DashboardModel.DashboardMenu> dashboardMenuList;
    Context context;

    public DashboardAdapter(List<DashboardModel.DashboardMenu> menuList, Context context) {
        this.dashboardMenuList = menuList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dashboard, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(dashboardMenuList.get(position).getImageResource());
        holder.textView.setText(dashboardMenuList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dashboardMenuList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageview_card)
        ImageView imageView;
        @Bind(R.id.textview_card_dashboard)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
