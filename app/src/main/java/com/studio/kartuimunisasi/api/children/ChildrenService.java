package com.studio.kartuimunisasi.api.children;

import com.google.gson.JsonObject;
import com.studio.kartuimunisasi.api.user.UsersModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by NwP.
 */
public interface ChildrenService {
    /**
     * return the list of children by user_id (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/users/{id}/children")
    Call<ChildrenModel> getChildren(@Header("authorization") String authorization,
                                    @Path("id") Integer Id);

    /**
     * return the list of child by user_id and child_id (GET)
     *
     * @param authorization
     * @param Id
     * @param Id            child
     */
    @GET("/users/{user_id}/children/{id}")
    Call<ChildrenModel> getChildrenById(@Header("authorization") String authorization,
                                        @Path("user_id") Integer User_id,
                                        @Path("id") Integer Id);

    /**
     * return the list of users (GET)
     */
    @GET("/users")
    Call<UsersModel> getUsers();

    @Multipart
    @POST("/users/{id}/upload")
    void postUpload(@Header("authorization") String authorization,
                    @Part("image") JsonObject file);
}
