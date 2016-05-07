package com.studio.kartuimunisasi.api.user;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by NwP.
 */
public interface UsersService {
    /**
     * register user (POST)
     *
     * @param email
     * @param password
     */
    @POST("/users/signup")
    Call<UsersModel>
    postSignUp(@Field("email") String email,
               @Field("password") String password);


    /**
     * login user (POST)
     *
     * @param email
     * @param password
     */
    @FormUrlEncoded
    @POST("/users/authenticate")
    Call<UsersModel>
    loginUsers(@Field("email") String email,
               @Field("password") String password);

    /**
     * put the update of user's data (PUT)
     *
     * @param authorization
     * @param Id
     * @param name
     * @param country
     * @param state
     * @param address
     * @param phone
     * @param tempatLahir
     * @param tglLahir
     */
    @FormUrlEncoded
    @PUT("/users/{id}")
    Call<UsersModel> putEditUser(@Header("authorization") String authorization,
                                 @Path("id") Integer Id,
                                 @Field("name") String name,
                                 @Field("country") String country,
                                 @Field("state") String state,
                                 @Field("address") String address,
                                 @Field("phone") String phone,
                                 @Field("tempatLahir") String tempatLahir,
                                 @Field("tglLahir") String tglLahir);

    /**
     * return the user's data (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/users/{id}")
    Call<UsersModel> getUsers(@Header("authorization") String authorization,
                              @Path("id") Integer Id);

}
