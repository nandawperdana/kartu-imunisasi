package com.studio.kartuimunisasi.api.attributes;

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
public interface AttributeService {
    /**
     * post child data (POST)
     *
     * @param authorization
     * @param name
     * @param type
     */
    @FormUrlEncoded
    @POST("/attributes")
    Call<AttributesModel> postCreate(@Header("authorization") String authorization,
                                     @Field("name") String name,
                                     @Field("type") String type);

    /**
     * put the update of user's data (PUT)
     *
     * @param authorization
     * @param id
     * @param name
     * @param type
     */
    @FormUrlEncoded
    @PUT("/attributes/{id}")
    Call<AttributesModel> putEdit(@Header("authorization") String authorization,
                                  @Path("id") Integer id,
                                  @Field("name") String name,
                                  @Field("type") String type);


    /**
     * return the child data (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/attributes/{id}")
    Call<AttributesModel> getAttribute(@Header("authorization") String authorization,
                                       @Path("id") Integer Id);

    /**
     * return the list of attributes (GET)
     */
    @GET("/attributes")
    Call<AttributesModel> getAttributes();

    /**
     * return the list of attributes by type (GET)
     *
     * @param type
     */
    @GET("/attributes/shows/{type}")
    void getAttributesByType(@Path("type") String type);
}
