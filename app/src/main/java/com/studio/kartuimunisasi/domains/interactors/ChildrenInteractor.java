package com.studio.kartuimunisasi.domains.interactors;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.APICallManager;
import com.studio.kartuimunisasi.api.v1.children.ChildrenModel;
import com.studio.kartuimunisasi.api.v1.history.VaccineHistoriesModel;
import com.studio.kartuimunisasi.utils.commons.Enums;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nandawperdana on 5/11/2016.
 */
public class ChildrenInteractor {
    APICallListener listener;

    public ChildrenInteractor(APICallListener listener) {
        this.listener = listener;
    }

    public void callAPICreate(String name, Integer userId, String birthPlace,
                              String birthDay, Double weight, Double height,
                              String gender) {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_CREATE;
        Call<ChildrenModel> call = APICallManager.getInstance().
                childrenManager.create(name, userId, birthPlace, birthDay, weight, height, gender);
        call.enqueue(new Callback<ChildrenModel>() {
            @Override
            public void onResponse(Call<ChildrenModel> call, Response<ChildrenModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ChildrenModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIEdit(String name, Integer id, Integer userId,
                            String birthPlace, String birthDay,
                            Double weight, Double height, String gender) {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_EDIT;
        Call<ChildrenModel> call = APICallManager.getInstance().
                childrenManager.edit(name, id, userId, birthPlace, birthDay, weight, height, gender);
        call.enqueue(new Callback<ChildrenModel>() {
            @Override
            public void onResponse(Call<ChildrenModel> call, Response<ChildrenModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ChildrenModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetChildren() {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_GET;
        Call<ChildrenModel> call = APICallManager.getInstance().childrenManager.getChildren();
        call.enqueue(new Callback<ChildrenModel>() {
            @Override
            public void onResponse(Call<ChildrenModel> call, Response<ChildrenModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ChildrenModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetChildrenById(Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_GET;
        Call<ChildrenModel> call = APICallManager.getInstance().childrenManager.getChildrenById(id);
        call.enqueue(new Callback<ChildrenModel>() {
            @Override
            public void onResponse(Call<ChildrenModel> call, Response<ChildrenModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ChildrenModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetHistories(Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_GET_HISTORIES;
        Call<VaccineHistoriesModel> call = APICallManager.getInstance().
                childrenManager.getHistories(id);
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

    public void callAPIGetHistory(Integer childId, Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_GET_HISTORY;
        Call<VaccineHistoriesModel> call = APICallManager.getInstance().
                childrenManager.getHistory(childId, id);
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

    public void callAPIUploadImage(RequestBody image) {
        final Enums.APIRoute route = Enums.APIRoute.CHILDREN_UPLOAD;
        Call<ChildrenModel> call = APICallManager.getInstance().childrenManager.uploadImage(image);
        call.enqueue(new Callback<ChildrenModel>() {
            @Override
            public void onResponse(Call<ChildrenModel> call, Response<ChildrenModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<ChildrenModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }
}
