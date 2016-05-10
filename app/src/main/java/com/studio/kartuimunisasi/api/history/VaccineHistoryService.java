package com.studio.kartuimunisasi.api.history;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by nandawperdana on 5/9/2016.
 */
public interface VaccineHistoryService {
    /**
     * post child data (POST)
     *
     * @param child_id
     * @param date
     * @param place
     * @param attribute_id
     */
    @FormUrlEncoded
    @POST("/histories")
    Call<VaccineHistoriesModel> postCreate(@Header("authorization") String authorization,
                                           @Field("child_id") Integer child_id,
                                           @Field("date") String date,
                                           @Field("place") String place,
                                           @Field("attribute_id") Integer attribute_id);

    /**
     * put the update of user's data (PUT)
     *
     * @param authorization
     * @param id
     * @param childId
     * @param date
     * @param place
     * @param attributeId
     */
    @FormUrlEncoded
    @PUT("/histories/{id}")
    Call<VaccineHistoriesModel> putEdit(@Header("authorization") String authorization,
                                        @Path("id") Integer id,
                                        @Field("child_id") Integer childId,
                                        @Field("date") String date,
                                        @Field("place") String place,
                                        @Field("attribute_id") Integer attributeId);

    /**
     * return the child data (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/histories/{id}")
    Call<VaccineHistoriesModel> getHistory(@Header("authorization") String authorization,
                                           @Path("id") Integer Id);

    /**
     * return the list of histories (GET)
     */
    @GET("/histories")
    Call<VaccineHistoriesModel> getHistories();
}
