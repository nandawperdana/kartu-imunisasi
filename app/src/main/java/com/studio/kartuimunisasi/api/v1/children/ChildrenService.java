package com.studio.kartuimunisasi.api.v1.children;

import com.studio.kartuimunisasi.api.v1.history.VaccineHistoriesModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by NwP.
 */
public interface ChildrenService {
    /**
     * post child data (POST)
     *
     * @param authorization
     * @param name
     * @param userId
     * @param birthPlace
     * @param birthDay
     * @param weight
     * @param height
     * @param gender
     */
    @FormUrlEncoded
    @POST("/children")
    Call<ChildrenModel> postCreateChildren(@Header("authorization") String authorization,
                                           @Field("name") String name,
                                           @Field("user_id") Integer userId,
                                           @Field("birthplace") String birthPlace,
                                           @Field("birthday") String birthDay,
                                           @Field("weight") Double weight,
                                           @Field("height") Double height,
                                           @Field("gender") String gender);

    /**
     * put the update of user's data (PUT)
     *
     * @param authorization
     * @param id
     * @param name
     * @param userId
     * @param birthPlace
     * @param birthDay
     * @param weight
     * @param height
     * @param gender
     */
    @FormUrlEncoded
    @PUT("/children/{id}")
    Call<ChildrenModel> putEdit(@Header("authorization") String authorization,
                                @Path("id") Integer id,
                                @Field("name") String name,
                                @Field("user_id") Integer userId,
                                @Field("birthplace") String birthPlace,
                                @Field("birthday") String birthDay,
                                @Field("weight") Double weight,
                                @Field("height") Double height,
                                @Field("gender") String gender);


    /**
     * return the child data (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/children/{id}")
    Call<ChildrenModel> getChildrenById(@Header("authorization") String authorization,
                                        @Path("id") Integer Id);

    /**
     * return the list of vaccination histories by child_id (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/children/{id}/histories")
    Call<VaccineHistoriesModel> getHistories(@Header("authorization") String authorization,
                                           @Path("id") Integer Id);

    /**
     * return the vaccination history of child by child_id and history_id (GET)
     *
     * @param authorization
     * @param childId
     * @param Id
     */
    @GET("/children/{child_id}/children/{id}")
    Call<VaccineHistoriesModel> getHistory(@Header("authorization") String authorization,
                                           @Path("child_id") Integer childId,
                                           @Path("id") Integer Id);

    /**
     * return the list of children (GET)
     */
    @GET("/children")
    Call<ChildrenModel> getChildren();

    @Multipart
    @POST("/children/{id}/upload")
    Call<ChildrenModel> postUploadImage(@Header("authorization") String authorization,
                                        @Part("image") RequestBody image);
}
