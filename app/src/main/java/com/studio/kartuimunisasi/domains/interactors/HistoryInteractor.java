package com.studio.kartuimunisasi.domains.interactors;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.APICallManager;
import com.studio.kartuimunisasi.api.v1.history.VaccineHistoriesModel;
import com.studio.kartuimunisasi.utils.commons.Enums;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class HistoryInteractor implements Interactor {
    APICallListener listener;

    public HistoryInteractor(APICallListener listener) {
        this.listener = listener;
    }

    public void callAPIGetHistories() {
        final Enums.APIRoute route = Enums.APIRoute.HISTORIES_GET;
        Call<VaccineHistoriesModel> call = APICallManager.getInstance().
                historyManager.getHistories();
        call.enqueue(new Callback<VaccineHistoriesModel>() {
            @Override
            public void onResponse(Call<VaccineHistoriesModel> call,
                                   Response<VaccineHistoriesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<VaccineHistoriesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetHistory(Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.HISTORIES_GET;
        Call<VaccineHistoriesModel> call = APICallManager.getInstance().
                historyManager.getHistoryById(id);
        call.enqueue(new Callback<VaccineHistoriesModel>() {
            @Override
            public void onResponse(Call<VaccineHistoriesModel> call,
                                   Response<VaccineHistoriesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<VaccineHistoriesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIEdit(Integer id, Integer childId, String date,
                            String place, Integer attributeId) {
        final Enums.APIRoute route = Enums.APIRoute.HISTORIES_EDIT;
        Call<VaccineHistoriesModel> call = APICallManager.getInstance().
                historyManager.edit(id, childId, date, place, attributeId);
        call.enqueue(new Callback<VaccineHistoriesModel>() {
            @Override
            public void onResponse(Call<VaccineHistoriesModel> call,
                                   Response<VaccineHistoriesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<VaccineHistoriesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }
}
