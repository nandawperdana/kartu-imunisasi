package com.studio.kartuimunisasi.domains.interactors;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.APICallManager;
import com.studio.kartuimunisasi.api.v1.attributes.AttributesModel;
import com.studio.kartuimunisasi.utils.commons.Enums;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class AttributeInteractor implements Interactor {
    APICallListener listener;

    public AttributeInteractor(APICallListener listener) {
        this.listener = listener;
    }

    public void callAPIEdit(Integer id, String name, String type) {
        final Enums.APIRoute route = Enums.APIRoute.ATTRIBUTES_EDIT;
        Call<AttributesModel> call = APICallManager.getInstance().attributeManager.edit(id, name, type);
        call.enqueue(new Callback<AttributesModel>() {
            @Override
            public void onResponse(Call<AttributesModel> call, Response<AttributesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<AttributesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPICreate(String name, String type) {
        final Enums.APIRoute route = Enums.APIRoute.ATTRIBUTES_CREATE;
        Call<AttributesModel> call = APICallManager.getInstance().attributeManager.create(name, type);
        call.enqueue(new Callback<AttributesModel>() {
            @Override
            public void onResponse(Call<AttributesModel> call, Response<AttributesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<AttributesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetAttributes() {
        final Enums.APIRoute route = Enums.APIRoute.ATTRIBUTES_GET;
        Call<AttributesModel> call = APICallManager.getInstance().attributeManager.getAttributes();
        call.enqueue(new Callback<AttributesModel>() {
            @Override
            public void onResponse(Call<AttributesModel> call, Response<AttributesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<AttributesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetAttribute(Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.ATTRIBUTES_GET;
        Call<AttributesModel> call = APICallManager.getInstance().attributeManager.getAttribute(id);
        call.enqueue(new Callback<AttributesModel>() {
            @Override
            public void onResponse(Call<AttributesModel> call, Response<AttributesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<AttributesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetAttributes(String type) {
        final Enums.APIRoute route = Enums.APIRoute.ATTRIBUTES_GET;
        Call<AttributesModel> call = APICallManager.getInstance().attributeManager.getAttributes(type);
        call.enqueue(new Callback<AttributesModel>() {
            @Override
            public void onResponse(Call<AttributesModel> call, Response<AttributesModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<AttributesModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }
}
