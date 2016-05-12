package com.studio.kartuimunisasi.domains.interactors;

import com.studio.kartuimunisasi.api.APICallListener;
import com.studio.kartuimunisasi.api.APICallManager;
import com.studio.kartuimunisasi.api.v1.children.ChildrenModel;
import com.studio.kartuimunisasi.api.v1.user.UsersModel;
import com.studio.kartuimunisasi.utils.commons.Enums;

import okhttp3.RequestBody;
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

    public void callAPISignUp(String email, String password) {
        final Enums.APIRoute route = Enums.APIRoute.SIGN_UP;
        Call<UsersModel> call = APICallManager.getInstance().userManager.signUp(email, password);
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

    public void callAPILogin(String email, String password) {
        final Enums.APIRoute route = Enums.APIRoute.LOGIN;
        Call<UsersModel> call = APICallManager.getInstance().userManager.login(email, password);
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

    public void callAPIGetUsers() {
        final Enums.APIRoute route = Enums.APIRoute.USERS_GET;
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
        final Enums.APIRoute route = Enums.APIRoute.USERS_GET;
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

    public void callAPIEditUser(Integer id, String name, String country, String state,
                                String address, String phone, String birthPlace,
                                String birthDate) {
        final Enums.APIRoute route = Enums.APIRoute.USERS_EDIT;
        Call<UsersModel> call = APICallManager.getInstance().
                userManager.edit(id, name, country, state, address, phone, birthPlace, birthDate);
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

    public void callAPIGetUser(Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.USERS_GET;
        Call<UsersModel> call = APICallManager.getInstance().userManager.getUser(id);
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

    public void callAPIGetChildren(Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.USERS_GET_CHILDREN;
        Call<ChildrenModel> call = APICallManager.getInstance().userManager.getChildren(id);
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

    public void callAPIGetChildren(Integer userId, Integer id) {
        final Enums.APIRoute route = Enums.APIRoute.USERS_GET_CHILDREN;
        Call<ChildrenModel> call = APICallManager.getInstance().
                userManager.getChildrenById(userId, id);
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

    public void callAPIUploadImage(RequestBody image) {
        final Enums.APIRoute route = Enums.APIRoute.USERS_UPLOAD;
        Call<UsersModel> call = APICallManager.getInstance().userManager.uploadImage(image);
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
