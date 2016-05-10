package com.studio.kartuimunisasi.domains.interactors;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.APICallManager;
import com.studio.kartuimunisasi.api.user.UsersModel;
import com.studio.kartuimunisasi.utils.Enums;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nandawperdana on 5/10/2016.
 */
public class UserInteractor implements Interactor {

    APICallListener listener;

    public UserInteractor(APICallListener listener) {
        this.listener = listener;
    }

    public void callAPIGetUsers() {
        final Enums.APIRoute route = Enums.APIRoute.GET_USERS;
        Call<UsersModel> call = APICallManager.getInstance().userManager.getUsers();
        call.enqueue(new Callback<UsersModel>() {
            @Override
            public void onResponse(Call<UsersModel> call, Response<UsersModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<UsersModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }

    public void callAPIGetUser() {
        final Enums.APIRoute route = Enums.APIRoute.GET_USERS;
        Call<UsersModel> call = APICallManager.getInstance().userManager.getUsers();
        call.enqueue(new Callback<UsersModel>() {
            @Override
            public void onResponse(Call<UsersModel> call, Response<UsersModel> response) {
                listener.onAPICallSucceed(route, response.body());
            }

            @Override
            public void onFailure(Call<UsersModel> call, Throwable t) {
                listener.onAPICallFailed(route, t);
            }
        });
    }
}
